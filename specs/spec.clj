(ns specs.spec
  (:use spec)
  (:use mocking)
  (:use collection-utils)
  (:use clojure.test)
  (:use clojure.walk))

(defn is-macroexpanded [expected actual]
  (is (= (macroexpand-all expected) (macroexpand-all actual))))

(deftest defspec-expands-properly
  (is-macroexpanded
    `(deftest spec-name (is (= 1 (only [1]))))
    `(defspec spec-name (only [1]) => 1)))

(deftest defspec-with-stubbing-expands-properly
  (is-macroexpanded
    `(deftest spec-name (is (stubbing [x 4] (= 1 (only [1])))))
    `(defspec spec-name (stubbing [x 4] (onluy [1])) => 1)))

(deftest defspec-exception-expands-properly
  (is-macroexpanded
    `(deftest spec-name (is (~'thrown-with-msg? Exception #"message" (only []))))
    `(defspec-exception spec-name
      Exception
      (only []))))

(deftest defspec-exception-msg-expands-properly
  (is-macroexpanded
    `(deftest spec-name (is (~'thrown-with-msg? Exception #"message" (only []))))
    `(defspec-exception-msg spec-name
      Exception #"message"
      (only []))))

(run-tests)