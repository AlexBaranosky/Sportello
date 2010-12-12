(ns pages
  (:use utilities)
  (:use google-maps)
  (:use stringtemplate-clj.core))

(defn template [filename attributes]
  (->
    (load-template template-dir filename)
    (update-template attributes)
    str))

(defn home-page []
  (template "layout" {"user" "New User"}))

(defn list-distances-page [addresses]
  (let [dists (->> addresses lines (map #(.trim %)) (apply distances "Brookline,MA"))]
    (template "listdistances" {"distances" dists})))

(defn not-found-404 []
  (template "not-found" {}))