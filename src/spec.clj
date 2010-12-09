(ns spec
  (:use clojure.test))

(defmacro defspec [name actual arrow expected]
  `(deftest ~name (is (= ~expected ~actual))))

(defn evaluate-specs []
  (run-tests))
