(ns fact.google-maps
  (:use google-maps)
  (:use mocking)
  (:use midje.sweet)
  (:use spec))

(fact "distance in miles between two locations"
  (dist-in-miles "NewYork,NY" "Boston,MA") => 219.061928254832)

(fact "retrieves distances in miles to multiple locations from origin"
 (distances "Boston,MA" "Albany,NY" "LosAngeles,CA") => (in-any-order [2.0, 2.0])
 (provided (dist-in-miles anything anything) => 2.0))

(fact "can convert distances from origin to a map keyed by destination"
 (map-of-distances .orig. "Newport,RI", "LosAngeles,CA") => { "Newport,RI" 55, "LosAngeles,CA" 3000 }
 (provided
   (dist-in-miles .orig. "Newport,RI") => 55
   (dist-in-miles .orig. "LosAngeles,CA") => 3000))

(fact "gets map of relative values of locations dependent on frequency of visits per year"
   (relative-distances .orig. "Newport,RI" 1 "LosAngeles,CA" 2) => { "Newport,RI" 365.0, "LosAngeles,CA" 730.0 }
   (provided
     (dist-in-miles .orig. anything) => 365.0))

(fact "sdfaf"
  (dist-in-miles "Boston,MA" "Newport,RI") => (throws RuntimeException "Exceeded Google's query limit.")
  (provided (directions-json "Boston,MA" "Newport,RI") => {:status "OVER_QUERY_LIMIT" :routes []} ))