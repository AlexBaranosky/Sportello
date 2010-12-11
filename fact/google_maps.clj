(ns fact.google-maps
  (:use google-maps)
  (:use midje.sweet))

(fact "retrieves distance in miles between two locations"
  (dist-in-miles "NewYork,NY" "Boston,MA") => 219.061928254832)

(fact "retrieves distances in miles to multiple locations from origin"
 (distances "Boston,MA" "Albany,NY" "LosAngeles,CA") => (in-any-order [3.0, 2.0])
 (provided (dist-in-miles "Boston,MA" "Albany,NY") => 2.0)
 (provided (dist-in-miles "Boston,MA" "LosAngeles,CA") => 3.0))

(fact "converts distances from origin to a map keyed by destination"
 (map-of-distances .origin. "Newport,RI", "LosAngeles,CA") => { "Newport,RI" 55, "LosAngeles,CA" 3000 }
 (provided
   (dist-in-miles .origin. "Newport,RI") => 55
   (dist-in-miles .origin. "LosAngeles,CA") => 3000))

(fact "gets map of relative values of locations dependent on frequency of visits per year"
   (relative-distances .origin. "Newport,RI" 1 "LosAngeles,CA" 2) => { "Newport,RI" 365.0, "LosAngeles,CA" 730.0 }
   (provided
     (dist-in-miles .origin. anything) => 365.0))

(fact "throws if Google has exceeded its query limit"
  (dist-in-miles "Boston,MA" "Newport,RI") => (throws RuntimeException "Exceeded Google's query limit.")
  (provided (directions-json "Boston,MA" "Newport,RI") => {:status "OVER_QUERY_LIMIT" :routes []} ))