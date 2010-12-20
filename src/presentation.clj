(ns presentation
  (:use google-maps)
  (:use clojure.contrib.def))

;(def fibs
;  (lazy-cat [0 1] (map + fibs (rest fibs))))
;
;(defn long-running-fn [_]
;  (Thread/sleep 10))
;
;(time (doall (map long-running-fn (range 1000))))
;(time (doall (pmap long-running-fn (range 1000))))
;
;(def fibs
;  (lazy-cat [0 1] (map + fibs (rest fibs))))
;
;(println (time
;  (pmap lenthy-fn (take 100 fibs))))

;(def destinations ["NewYork,NY" "LosAngeles,CA" "Miami,FL" "Detroit,MI" "Austin,Tx" "MexicoCity,Mexico" "Toronto,Canada" "Buffalo,Ny" "Newport,RI"
;                   "NewYork,NY" "LosAngeles,CA" "Miami,FL" "Detroit,MI" "Austin,Tx" "MexicoCity,Mexico" "Toronto,Canada" "Buffalo,Ny" "Newport,RI"])
;
;(defn pdistances [origin & locations]
;  (->> locations (pmap #(dist-in-miles origin %)) (remove nil?)))
;
;(def pdistances-to-boston
;  (partial pdistances "Boston,MA"))
;
;(def distances-to-boston
;  (partial pdistances "Boston,MA"))
;
;(println (time
;  (count (apply pdistances-to-boston destinations))))
;
;(println (time
;  (count (apply distances-to-boston destinations))))


;(defn one-to-million []
;  "Sum all the values from 1 to 1000000"
;  (reduce + (range 1 1000001)))
;
;(time (one-to-million))
;(time (one-to-million))
;
;(defn-memo memoized-one-to-million []
;  (reduce + (range 1 1000001)))
;
;(time (memoized-one-to-million))
;(time (memoized-one-to-million))

;(def ref1 (ref #{}))
;(def ref2 (ref "A"))
;
;(dosync
;  (ref-set ref1 #{1})
;  (ref-set ref2 "B"))
;
;(println @ref1)
;(println @ref2)
;
;(try
;  (dosync
;    (ref-set ref1 #{1})
;    (throw (Exception. "exception in transaction!"))
;    (ref-set ref2 "B"))
;  (catch Exception e))
;
;(println @ref1) (memoize)
;(println @ref2)