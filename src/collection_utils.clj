(ns collection-utils)

(defn only [coll]
  (if (= 1 (count coll))
    (first coll)
    (throw (RuntimeException. (format "should have precisely one item, but had: %s" (count coll))))))

(defn map-by-key [f & maps]
  (into {}
    (for [k (keys (first maps))]
      [k (apply f (map #(get % k) maps))])))

;(defn zip [seq-of-seqs]
;  (apply map list seq-of-seqs))

(def zip (partial apply (partial map list)))



