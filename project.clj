(defproject sportello "1.0.0-SNAPSHOT"
  :description "Sportello is an app to tell you which places are good places to move to"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [midje "0.9.0"]
                 [clojurecheck "2.0.2"]
                 [org.clojars.arohner/ring-core "f47973382a035d67bd8f9d2890de40aabd65b45f"]
                 [compojure "0.5.3"]
                 [stringtemplate-clj "0.1.0"]
                 [org.clojars.sids/congomongo "0.1.3-SNAPSHOT"]
                 [ring/ring-jetty-adapter "0.3.4"]]
  :dev-dependencies [[lein-ring "0.2.4"]]
  :ring {:handler server/all-routes})
