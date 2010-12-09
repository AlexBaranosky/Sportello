(ns facts
  (:use google-maps)
  (:use spec)
  (:use collection-utils))

(defspec distance-in-miles-between-two-locations
  (dist-in-miles "NewYork,NY" "Boston,MA") => 219.061928254832)

(defspec distances-in-miles-to-multiple-locations-from-origin
  (distances "Boston,MA" "Newport,RI" "LosAngeles,CA")
  => [71.810625917056 2990.973960919152])

(defspec distances-map-to-multiple-locations-from-origin
  (map-of-distances "Boston,MA" "Newport,RI" "LosAngeles,CA")
  => {"LosAngeles,CA" 2990.973960919152, "Newport,RI" 71.810625917056})

(defspec relative-values-of-locations-dependent-on-frequency-of-visits-per-year
  (relative-distances "Boston,MA" "Newport,RI" 12 "LosAngeles,CA" 1)
  => {"LosAngeles,CA" 2990.973960919152, "Newport,RI" 861.727511004672})


;(println "defspace macro expandsion:")
;(println (macroexpand-1 `(defspec something-is-awesome ("Awesome") => ("Awesome"))))

(evaluate-specs)