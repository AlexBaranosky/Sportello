(ns pages
  (:use utilities)
  (:use stringtemplate-clj.core))

(defn template [filename attributes]
  (->
    (load-template template-dir filename)
    (update-template attributes)))

(defn home-page []
  (str (template "layout" {"user" "New User"})))

(defn not-found-404 []
  (str (template "not-found" {})))