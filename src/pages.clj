(ns pages
  (:require (clojure.contrib [str-utils :as str]))
  (:use utilities)
  (:use collection-utils)
  (:use template)
  (:use google-maps))

(defn home []
  (use-layout "home" {"user" "New User"}))

(defn- split-into-addresses-and-freqs [addresses-w-whitespace]
  (->> addresses-w-whitespace lines (map remove-whitespace) (map #(.split % ":" 2)) unzip))

(defn list-distances [origin-w-whitespace addresses-w-whitespace]
  (let [origin (remove-whitespace origin-w-whitespace)
        [addresses freq-strings] (split-into-addresses-and-freqs addresses-w-whitespace)
        freqs (map #(Integer/parseInt %) freq-strings)
        dists (apply map-of-distances origin addresses)
        total-dist-per-year (apply total-distance origin (interleave addresses freqs))]
    (use-layout "list_distances" {"origin" origin "distances" dists "totaldistance" total-dist-per-year})))

(defn not-found-404 []
  (use-layout "not_found"))