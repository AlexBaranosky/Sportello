(ns pages
  (:require (clojure.contrib [str-utils :as str]))
  (:use utilities)
  (:use collection-utils)
  (:use template)
  (:use google-maps))

(defn home []
  (use-layout "home"))

(defn- split-into-two-columns-by-divider [text divider]
  (->> text split-lines (map remove-whitespace) (map #(.split % divider 2)) unzip))

(defn list-distances [origin-w-whitespace addresses-n-freqs-w-whitespace]
  (let [origin (remove-whitespace origin-w-whitespace)
        [addresses freq-strings] (split-into-two-columns-by-divider addresses-n-freqs-w-whitespace ":")
        freqs (map #(Integer/parseInt %) freq-strings)
        dists (apply map-of-distances origin addresses)
        total-dist-per-year (apply total-distance origin (interleave addresses freqs))]
    (use-layout "list_distances" {"origin" origin "distances" dists "totaldistance" total-dist-per-year})))

(defn not-found-404 []
  (use-layout "not_found"))