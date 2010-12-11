(ns routes
  (:use [compojure.core]
    [ring.adapter.jetty])
  (:use stringtemplate-clj.core)
  (:use utilities)
  (:require [compojure.route :as route])
  )
(defn template [filename attributes]
  (->
    (path-combine template-dir "layout")
    (load-template filename)
    (update-template attributes)))

(def home-template
  (template "layout" {"body" "hello Alex!!!"}))

(def page-not-found-template "<h1>Page not found</h1>")

(defroutes sportello
  (GET "/" [] (str home-template))
  (route/files "/" {:root "public"})
  (route/not-found page-not-found-template))

(run-jetty sportello {:port 8080})
