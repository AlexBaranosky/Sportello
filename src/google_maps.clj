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
  (let [request-url (directions-url (remove-whitespace origin) (remove-whitespace dest))
        response (string (http-agent request-url))]
    (println origin)
    (println dest)
    (println "BOO!")
    (println response)
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
  (let [dists (apply distances origin locations)]
    (zipmap locations dists)))

(defn scaled-distance [origin location freq]
  (* freq (dist-in-miles origin location)))

(defn total-distance [origin & locations+frequencies]
  (let [sum-scaled-dists (fn [acc [loc freq]] (+ acc (scaled-distance origin loc freq)))]
    (reduce sum-scaled-dists 0 (partition 2 locations+frequencies))))

(defn map-of-total-distances [origin & locations+frequencies]
  (let [locations (take-nth 2 locations+frequencies)
        scaled-distances (map (fn [[loc freq]] (scaled-distance origin loc freq)) (partition 2 locations+frequencies))]
    (zipmap locations scaled-distances)))
