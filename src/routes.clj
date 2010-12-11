(ns routes
  (:use [compojure.core]
    [ring.adapter.jetty])
  (:use stringtemplate-clj.core)
  (:use utilities)
  (:require [compojure.route :as route])
  )
(defn template [filename attributes]
  (->
    (load-template template-dir filename)
    (update-template attributes)))

(def home-template
  (template "layout" {"user" "Mario"}))

(def page-not-found-template
  (template "not-found" {}))

(defroutes sportello
  (GET "/" [] (str home-template))
  (route/files "/" {:root "public"})
  (route/not-found (str page-not-found-template)))

(run-jetty sportello {:port 8080})
