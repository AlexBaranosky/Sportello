(ns google-maps
  (:use collection-utils)
  (:use [clojure.contrib.http.agent :only [string http-agent]])
  (:use clojure.contrib.json))

(def miles-per-meter 0.000621371192)

(defn- meters-to-miles [meters]
  (* meters miles-per-meter))

(defn- directions-url [origin dest]
  (format "http://maps.googleapis.com/maps/api/directions/json?origin=%s&destination=%s&sensor=false" origin dest))

(defn- directions-json [origin dest]
  (let [request-url (directions-url origin dest)
        response (string (http-agent request-url))]
    (read-json response true)))

(defn dist-in-miles [origin dest]
  (let [json (directions-json origin dest)
        distance (-> json :routes only :legs only :distance :value)]
    (meters-to-miles distance)))

(defn map-of-distances [origin & locations]
  (loop [dists {} origin origin locations locations]
    (if (seq locations)
      (let [[loc & rst] locations
            dist (dist-in-miles origin loc)
            dists (assoc dists loc dist)]
        (recur dists origin rst))
      dists)))