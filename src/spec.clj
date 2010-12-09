(ns spec
  (:use clojure.test))

(defmacro defspec [name actual arrow expected]
  `(deftest ~name (is (= ~expected ~actual))))

(defmacro defspec-exception [name exception-class actual]
  `(deftest ~name (is (~'thrown? ~exception-class ~actual))))

(defmacro defspec-exception-msg [name exception-class msg actual]
  `(deftest ~name (is (~'thrown-with-msg? ~exception-class ~msg ~actual))))

(defn evaluate-specs []
  (run-tests))
