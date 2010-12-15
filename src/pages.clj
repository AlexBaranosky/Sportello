(ns pages
  (:use utilities)
  (:use template)
  (:use google-maps))

(defn home []
  (use-layout "home" {"user" "New User"}))

(defn list-distances [addresses-w-whitespace]
  (let [addresses (->> addresses-w-whitespace lines (map remove-whitespace))
        dists (apply map-of-distances "Brookline,MA" addresses)
        total-dist-per-year (total-distances "Brookline,MA" (first addresses) 500)]
    (use-layout "list_distances" {"distances" dists "totaldistance" total-dist-per-year})))

(defn not-found-404 []
  (use-layout "not_found"))