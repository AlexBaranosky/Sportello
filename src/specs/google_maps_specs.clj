(ns google-maps-specs
  (:use google-maps)
  (:use mocking)
  (:use spec)
  (:use clojure.walk)
  (:use collection-utils))

(defspec distance-in-miles-between-two-locations
  (dist-in-miles "NewYork,NY" "Boston,MA") => 219.061928254832)

(defspec distances-in-miles-to-multiple-locations-from-origin
<<<<<<< HEAD
  (stubbing [dist-in-miles 2.0]
    (distances "Boston,MA" "Newport,RI" "LosAngeles,CA"))
=======
  (distances "Boston,MA" "Newport,RI" "LosAngeles,CA")
>>>>>>> master
  => [2.0 2.0])

(defspec distances-map-to-multiple-locations-from-origin
  (map-of-distances "Boston,MA" "Newport,RI" "LosAngeles,CA")
  => {"LosAngeles,CA" 2.0, "Newport,RI" 2.0})

(defspec relative-values-of-locations-dependent-on-frequency-of-visits-per-year
<<<<<<< HEAD
  (stubbing [dist-in-miles 365.0]
    (relative-distances "Boston,MA" "Newport,RI" 2 "LosAngeles,CA" 1))
=======
  (relative-distances "Boston,MA" "Newport,RI" 2 "LosAngeles,CA" 1)
>>>>>>> master
  => {"LosAngeles,CA" 365.0, "Newport,RI" 730.0})

(defspec-exception-msg throws-exception-if-over-query-limit
  Exception #"Exceeded Google's query limit."
  (stubbing [directions-json { :status "OVER_QUERY_LIMIT" :routes [] }]
    (dist-in-miles "Boston,MA" "Newport,RI")))

(evaluate-specs)