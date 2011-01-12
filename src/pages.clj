(ns pages
  (:require (clojure.contrib [str-utils :as str]))
  (:use string-utils)
  (:use template)
  (:use google-maps))

(defn home []
  (use-layout "home"))

(defn list-distances [origin-w-whitespace addresses+freqs-w-whitespace]
  (let [origin (remove-whitespace origin-w-whitespace)
        [addresses freq-strings] (split-into-columns addresses+freqs-w-whitespace ":")
        freqs (->> freq-strings (map remove-whitespace) (map #(Integer/parseInt %)))
        dists (apply map-of-distances origin addresses)
        total-dist-per-year (apply total-distance origin (interleave addresses freqs))]
    (use-layout "list_distances" {"origin" origin-w-whitespace "distances" dists "totaldistance" total-dist-per-year})))

(defn not-found-404 []
  (use-layout "not_found"))