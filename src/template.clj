(ns template
  (:use stringtemplate-clj.core)
  (:require fs))

(defn but-last [s n]
   (if (> n (.length s))
       ""
      (.substring s 0 (- (.length s) n))))    
  
(def working-directory (but-last (fs/cwd) 1))  
  
(def template-dir (str working-directory "\\templates"))

(println template-dir)

(defn- template [filename attributes]
  (->
    (load-template template-dir filename)
    (update-template attributes)
    str))

(defn use-layout [template-name & attributes]
  (template "layout" (apply merge {"body_template" template-name} attributes)))