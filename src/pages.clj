(ns pages
  (:use utilities)
  (:use stringtemplate-clj.core))

(defn template [#^String txt #^java.util.Map context]
  (-> (StringTemplate. txt) (.setAttributes context) str))

(defn template [#^String filename #^java.util.Map attributes]
  (->
    (load-template template-dir filename)
    (update-template attributes)))

(defn home-page []
  (str (template "layout" {"user" "New User"})))

(defn not-found-404 []
  (str (template "not-found" {})))