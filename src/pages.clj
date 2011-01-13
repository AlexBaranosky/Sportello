(ns pages
  (:require (clojure.contrib [str-utils :as str]))
  (:use string-utils)
  (:use template)
  (:use google-maps))

(defn home []
  (use-layout "home"))

(defn list-distances [origin addresses+freqs-w-whitespace]
  (let [[addresses freq-strings] (split-into-columns addresses+freqs-w-whitespace ":")
        freqs (->> freq-strings (map remove-whitespace) (map #(Integer/parseInt %)))]
    (use-layout "list_distances" { "origin" origin 
                                   "map_of_distances" (apply map-of-distances origin addresses) 
                                   "total_distance" (apply total-distance origin (interleave addresses freqs)) })))

(defn not-found-404 []
  (use-layout "not_found"))