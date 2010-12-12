(ns server
  (:require
    [pages :as pages]
    (compojure [route :as route])
    (ring.adapter [jetty :as jetty]))
  (:use (compojure [core :only [defroutes GET POST ANY]])))

(defroutes all-routes
  (GET "/" []
    (pages/home-page))
  (POST "/"  {{addresses "addresses"} :form-params}
    (pages/list-distances-page addresses))
  (ANY "/*" []
    (pages/not-found-404)))

(jetty/run-jetty all-routes {:port 8080})