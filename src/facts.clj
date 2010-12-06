(ns facts
  (:use google-maps)
  (:use midje.sweet))

(fact
  (+ 1 4) => 5)

(fact ;gets distance between two cities, in meters
  (dist-in-meters "NewYork,NY" "Boston,MA") => 34)