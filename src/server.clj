(ns server
  (:require [pages :as pages])
  (:require [compojure.route :as route])
  (:use compojure.core)
  (:use ring.adapter.jetty))

(defroutes routes
  (route/files "/" {:root "public"})
  (GET "/" []
    (pages/home-page))

  (route/not-found
    (pages/not-found-404)))

(run-jetty routes {:port 8080})