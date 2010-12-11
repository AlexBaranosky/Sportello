(ns routes
  (:use [compojure.core]
    [ring.adapter.jetty])
  (:require [compojure.route :as route]))

(def home-template "<h1>Sportello</h1>")
(def page-not-found-template "<h1>Page not found</h1>")

(defroutes sportello
  (GET "/miles" [] home-template)
  (route/files "/" {:root "public"})
  (route/not-found page-not-found-template))

(run-jetty sportello {:port 8080})
