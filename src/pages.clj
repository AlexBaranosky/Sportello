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

(defn- use-layout [template-name & attributes]
  (template "layout" (apply merge {"body_template" template-name} attributes)))

(defn home-page []
  (use-layout "home" {"user" "New User"}))

(defn list-distances-page [addresses-w-whitespace]
  (let [addresses (->> addresses-w-whitespace lines (map remove-whitespace))
        dists (apply map-of-distances "Brookline,MA" addresses)
        total-dist-per-year (total-distances "Brookline,MA" (first addresses) 500)]
    (use-layout "list_distances" {"distances" dists "totaldistance" total-dist-per-year})))

(defn not-found-404 []
  (use-layout "not_found"))