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

(defn fmap
  ([f map1 map2]
    (into {} (for [[k v] map1] [k (f v (get map2 k))])))
  ([f map1 map2 map3]
    (into {} (for [[k v] map1] [k (f v (get map2 k) (get map3 k))])))
  ([f map1 map2 map3 map4]
    (into {} (for [[k v] map1] [k (f v (get map2 k) (get map3 k) (get map4 k))]))))