(ns pages
  (:use utilities)
  (:use stringtemplate-clj.core))

(defn template [filename attributes]
  (->
    (load-template template-dir filename)
    (update-template attributes)
    str))

(defn home-page []
  (template "layout" {"user" "New User"}))

(defn list-distances-page [addresses]
  (template "listdistances" {"addresses" addresses}))

(defn not-found-404 []
  (template "not-found" {}))