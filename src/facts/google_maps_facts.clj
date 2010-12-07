(ns facts
  (:use google-maps)
  (:use collection-utils)
  (:use midje.sweet))

(fact ;gets distance between two cities, in miles
  (dist-in-miles "NewYork,NY" "Boston,MA") => 219.061928254832)

(fact ;gets distances to multiple locations from origin
  (map-of-distances "Boston,MA" "Newport,RI" "LosAngeles,CA")
  => {"LosAngeles,CA" 2990.973960919152, "Newport,RI" 71.810625917056})

(fact ;gets distances to multiple locations from origin
  (map-of-distances* "Boston,MA" ["Newport,RI" "LosAngeles,CA"])
  => {"LosAngeles,CA" 2990.973960919152, "Newport,RI" 71.810625917056})

(fact ;gives relative values of places, dependent on the frequency you visit per year
  (relative-distance "Boston,MA" "Newport,RI" 12 "LosAngeles,CA" 1)
  => {"LosAngeles,CA" 2990.973960919152, "Newport,RI" 861.727511004672})
