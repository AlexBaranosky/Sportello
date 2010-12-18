(ns presentation
  (:use google-maps))

(def fibs
  (lazy-cat [0 1] (map + fibs (rest fibs))))

(defn long-running-fn [_]
  (count (Thread/sleep 10)))

;(time (doall (map  long-running-fn (range 1000))))
;(time (doall (pmap long-running-fn (range 1000))))

(def fibs
  (lazy-cat [0 1] (map + fibs (rest fibs))))

(defn lenthy-fn [x]
  (-> x (* x) (+ 7) (/ 17) (* 29) (/ 7)))

(println (time
  (map lenthy-fn (take 100 fibs))))
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