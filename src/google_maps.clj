(ns google-maps
  (:use collection-utils)
  (:use [clojure.contrib.http.agent :only [string http-agent]])
  (:use clojure.contrib.json))

(def miles-per-meter 0.000621371192)

(defn- meters-to-miles [meters]
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

(defn map-of-distances [origin & locations]
  (apply hash-map (interleave locations (apply distances origin locations))))

(defn relative-distances
  "Gives distance * frequency.
  frequencies are in days out of 365"
  [origin & locations-n-frequencies]
  {:pre [(even? (count locations-n-frequencies)),
         (every? string? (map first (partition 2 locations-n-frequencies)))
         (every? number? (map second (partition 2 locations-n-frequencies)))]}
  (let [loc-w-dists (apply map-of-distances origin (take-nth 2 locations-n-frequencies))
        loc-w-freqs (apply hash-map locations-n-frequencies)]
    (fmap * loc-w-dists loc-w-freqs)))
