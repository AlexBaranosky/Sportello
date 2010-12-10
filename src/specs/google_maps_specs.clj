(ns google-maps-specs
  (:use google-maps)
  (:use mocking)
  (:use spec)
  (:use clojure.walk)
  (:use collection-utils))

;(defspec distance-in-miles-between-two-locations
;  (dist-in-miles "NewYork,NY" "Boston,MA") => 219.061928254832)

;(defspec distances-in-miles-to-multiple-locations-from-origin
;  (binding [dist-in-miles (fn [& args] 2.0)]
;    (distances "Boston,MA" "Newport,RI" "LosAngeles,CA"))
;  => [2.0 2.0])

(defspec distances-map-to-multiple-locations-from-origin
  (stubbing [dist-in-miles 2.0]
    (map-of-distances "Boston,MA" "Newport,RI" "LosAngeles,CA"))
  => {"LosAngeles,CA" 2.0, "Newport,RI" 2.0})

(defspec relative-values-of-locations-dependent-on-frequency-of-visits-per-year
  (stubbing [dist-in-miles 365.0]
    (println (dist-in-miles "goat" "farmer"))
    (relative-distances "Boston,MA" "Newport,RI" 2 "LosAngeles,CA" 1))
  => {"LosAngeles,CA" 365.0, "Newport,RI" 730.0})

(defspec-exception throws-exception-if-over-query-limit
  Exception ;#"Exceeded Google's query limit."
;  (stubbing [directions-json "{ \"status\": \"OVER_QUERY_LIMIT\", \"routes\": [ ]}"]
    (distances "Boston,MA" "Newport,RI" "LosAngeles,CA"))
;)

(evaluate-specs)