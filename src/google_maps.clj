(ns google-maps
  ;  (:use [clojure.contrib.http.agent :only [string http-agent]])
  (:use clojure.contrib.http.agent)
  (:use clojure.contrib.json))

(defn- directions-url [origin dest]
  (format "http://maps.googleapis.com/maps/api/directions/json?origin=%s&destination=%s&sensor=false" origin dest))

(defn- google-map-json [origin dest]
  (let [request-url (directions-url origin dest)
        response (string (http-agent request-url))]
    (read-json response true)))

(defn dist-in-meters [origin dest]
  (let [json (google-map-json origin dest)]
    (-> json :routes first :legs first :steps first :distance :value)))