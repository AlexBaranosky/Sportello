(ns fact.google-maps
  (:use google-maps)
  (:use midje.sweet))

(fact "retrieves distance in miles between two locations"
  (dist-in-miles "NewYork,NY" "Boston,MA") => 219.059442770064)

(fact "retrieves distance in miles between two locations, works with locations that have spaces"
  (dist-in-miles "NewYork, NY" "Boston, MA ") => 219.059442770064)

(fact "returns nil when google can't find origin"
  (dist-in-miles "NON_EXISTANT_PLACE" "Boston,MA") => nil
  (provided (directions-json "NON_EXISTANT_PLACE" "Boston,MA") => {:status "NOT_FOUND" :routes []}))

(fact "returns nil when google can't find destination"
  (dist-in-miles "Boston,MA" "NON_EXISTANT_PLACE") => nil
  (provided (directions-json "Boston,MA" "NON_EXISTANT_PLACE") => {:status "NOT_FOUND" :routes []}))

(fact "returns nil when there are no results"
  (dist-in-miles "Brookline,MA" "Haiti") => nil
  (provided (directions-json "Brookline,MA" "Haiti") => {:status "ZERO_RESULTS" :routes []}))

(fact "throws exception when Google has exceeded its query limit"
  (dist-in-miles "Boston,MA" "Newport,RI") => (throws RuntimeException "Exceeded Google's query limit.")
  (provided (directions-json "Boston,MA" "Newport,RI") => {:status "OVER_QUERY_LIMIT" :routes []}))

(fact "retrieves distances in miles to multiple locations from origin"
  (distances "Boston,MA" "Albany,NY" "LosAngeles,CA") => (in-any-order [3.0, 2.0])
  (provided (dist-in-miles "Boston,MA" "Albany,NY") => 2.0)
  (provided (dist-in-miles "Boston,MA" "LosAngeles,CA") => 3.0))

(fact "filters out unfound locations when retrieving distances in miles to multiple locations from origin"
  (distances "Boston,MA" "NON_EXISTANT_PLACE" "LosAngeles,CA") => [3.0]
  (provided (dist-in-miles "Boston,MA" "NON_EXISTANT_PLACE") => nil)
  (provided (dist-in-miles "Boston,MA" "LosAngeles,CA") => 3.0))

(fact "converts distances from origin to a map keyed by destination"
  (map-of-distances .origin. "Newport,RI", "LosAngeles,CA") => {"Newport,RI" 55.0, "LosAngeles,CA" 3000.0}
  (provided
    (dist-in-miles .origin. "Newport,RI") => 55.0
    (dist-in-miles .origin. "LosAngeles,CA") => 3000.0))

(fact "converts distances from origin to a map keyed by destination, retaing spaces in destinations"
  (map-of-distances .origin. "Newport, RI", "Los Angeles, CA") => {"Newport, RI" 55.0, "Los Angeles, CA" 3000.0}
  (provided
    (dist-in-miles .origin. "Newport, RI") => 55.0
    (dist-in-miles .origin. "Los Angeles, CA") => 3000.0))

(fact "scales the distance by multiplying it by frequency"
  (scaled-distance .origin. ["Newport,RI" 3]) => 450.
  (provided (dist-in-miles .origin. "Newport,RI") => 150.000)) 

(fact "gets total distance to locations dependent on frequency of visits per year"
  (total-distance .origin. "Newport,RI" 1 "LosAngeles,CA" 2) => 900.0
  (provided
    (dist-in-miles .origin. anything) => 300.0))

(fact "gets map of total distance to locations dependent on frequency of visits per year"
  (map-of-total-distances .origin. "Newport,RI" 1 "LosAngeles,CA" 2) => {"Newport,RI" 365.0, "LosAngeles,CA" 730.0}
  (provided
    (dist-in-miles .origin. anything) => 365.0))