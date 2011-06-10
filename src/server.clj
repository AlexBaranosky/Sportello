(ns server
  (:require
    pages
    (compojure [route :as route])
    (ring.adapter [jetty :as jetty]))
  (:use (compojure [core :only [defroutes GET POST ANY]])))

(defroutes all-routes
  (GET "/" []
    (pages/home))
  (POST "/" [origin addresses]
    (pages/list-distances origin addresses))
  (route/not-found
    (pages/not-found-404)))

(defn boot [] 
  (jetty/run-jetty #'all-routes {:port 8080}))

(defn -main []
  (boot))
  
  
  ;(let [port (Integer/parseInt (get (System/getenv) "PORT" "8080"))]
    ;(jetty/run-jetty #'all-routes {:port 8080}))