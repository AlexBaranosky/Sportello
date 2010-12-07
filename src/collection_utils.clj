(ns collection-utils)

(defn values-of [k coll]
  (if-let [s (try (seq coll) (catch IllegalArgumentException _ nil))]
    (let [not-found (Object.)
          v (if (associative? coll) (get coll k not-found) not-found)
          v (if-not (= v not-found) [v])
          vs (map #(values-of k %) s)]
      (apply concat v vs))))

(defn only [coll]
  (if (= 1 (count coll))
    (first coll)
    (throw (RuntimeException. (format "should have precisely one item, but had: %s" (count coll))))))

(defn fmap [f & maps]
  (into {}
    (for [k (keys (first maps))]
      [k (apply f (map #(get % k) maps))])))