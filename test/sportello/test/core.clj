(ns sportello.test.core
  (:use [clojure.test] :reload)
  (:use midje.sweet))


(fact (+ 1 1) => 2)
;
;(deftest addition-still-works
;  (is (= 1 2)))