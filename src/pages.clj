(ns pages
;  (:require (clojure [string :as str]))
  (:require (clojure.contrib [str-utils :as str]))
  (:use utilities)
  (:use template)
  (:use google-maps))

(defn- blank? [s]
  (or (= nil s)
      (= "" (remove-whitespace s))))

(defn home []
  (use-layout "home" {"user" "New User"}))

(defn list-distances [addresses-w-whitespace]
  (let [lines (->> addresses-w-whitespace lines (map remove-whitespace))
        addresses-w-freqs (map #(.split % ":" 2) lines)
        addresses (map first addresses-w-freqs)
        freqs (->> addresses-w-freqs (map second) (map #(Integer/parseInt %)))
        dists (apply map-of-distances "Brookline,MA" addresses)
        total-dists (apply total-distances "Brookline,MA" (interleave addresses freqs))
        total-dist-per-year (reduce + (vals total-dists))]
    (use-layout "list_distances" {"distances" dists "totaldistance" total-dist-per-year})))

(defn not-found-404 []
  (use-layout "not_found"))