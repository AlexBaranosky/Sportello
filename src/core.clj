(ns core
  (:use [compojure.core]
    [ring.adapter.jetty])
  (:require [compojure.route :as route]))

(defroutes example
  (GET "/" [] "<h1>Sportello Busters!</h1>")
  (route/files "/" {:root "public"})
  (route/not-found "Page not found"))

(run-jetty example {:port 8080})
