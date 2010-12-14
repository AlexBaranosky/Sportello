(ns pages
  (:use utilities)
  (:use google-maps)
  (:use stringtemplate-clj.core))

(def template-dir "C:\\dev\\sportellos\\templates")

(defn- template [filename attributes]
  (->
    (load-template template-dir filename)
    (update-template attributes)
    str))

(defn home-page []
  (template "layout" {"user" "New User"}))

(defn list-distances-page [addresses-w-whitespace]
  (let [addresses (->> addresses-w-whitespace lines (map remove-whitespace))
        dists  (apply map-of-distances "Brookline,MA" addresses)
        total-dist-per-year (total-distances "Brookline,MA" (first addresses) 500)]
    (template "listdistances" {"distances" dists "totaldistance" total-dist-per-year})))

(defn not-found-404 []
  (template "not-found" {}))