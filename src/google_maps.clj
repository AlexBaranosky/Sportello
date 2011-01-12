(ns google-maps
  (:use collection-utils)
  (:use string-utils)
  (:use [clojure.contrib.http.agent :only [string http-agent]])
  (:use clojure.contrib.json))

(def miles-per-meter 0.000621371192)

(defn meters-to-miles [meters]
  (* meters miles-per-meter))

(defn- directions-url [origin dest]
  (format "http://maps.googleapis.com/maps/api/directions/json?origin=%s&destination=%s&sensor=false" origin dest))

(defn directions-json [origin dest]
  (let [request-url (directions-url origin dest)
        response (string (http-agent request-url))]
    (read-json response true)))

(defn dist-in-miles [origin dest]
  (let [json (directions-json origin dest)
        status (-> json :status)]
    (case status
      "OVER_QUERY_LIMIT" (throw (RuntimeException. "Exceeded Google's query limit."))
      ("NOT_FOUND" "ZERO_RESULTS") nil
      (-> json :routes only :legs only :distance :value meters-to-miles))))

(defn distances [origin & locations]
  (->> locations (map #(dist-in-miles origin %)) (remove nil?)))

(defn map-of-distances [origin & locations-w-whitespace]
  (let [locations (map remove-whitespace locations-w-whitespace)
        dists (apply distances origin locations)]
    (apply hash-map (interleave locations-w-whitespace dists))))

(defn map-of-total-distances
  "Gives distance * frequency.
  frequencies are in days out of 365"
  [origin & locations-n-frequencies]
  (let [locations (take-nth 2 locations-n-frequencies)
        loc-w-dists (apply map-of-distances origin locations)
        loc-w-freqs (apply hash-map locations-n-frequencies)]
    (map-by-key * loc-w-dists loc-w-freqs)))

(defn total-distance [origin & locations-n-frequencies]
  (let [total-dists (apply map-of-total-distances origin locations-n-frequencies)]
    (reduce + (vals total-dists))))
