(ns string-template
  (:import [org.antlr.stringtemplate StringTemplate StringTemplateGroup]))

(defn load-template [directory name]
  (.. (StringTemplateGroup. "" directory) (getInstanceOf name)))

(defn update-template [template data]
  (let [new-template  (.. template getInstanceOf)]
    (doseq [[k v] (concat (seq (.. template getAttributes)) data)]
      (.. new-template (setAttribute k v)))
    new-template))

(defn render-template [template data]
  (str (update-template template data)))

