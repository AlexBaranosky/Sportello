(ns template
  (:use stringtemplate-clj.core))

(def template-dir "/home/alex/proj/Sportello/templates")

(defn- template [filename attributes]
  (->
    (load-template template-dir filename)
    (update-template attributes)
    str))

(defn use-layout [template-name & attributes]
  (template "layout" (apply merge {"body_template" template-name} attributes)))