; courtesy of Amit Rathore
; http://s-expressions.com/2010/01/24/conjure-simple-mocking-and-stubbing-for-clojure-unit-tests/
; and Clojure in Action

(ns mocking
  (:use clojure.test))

(def mock-calls (atom {}))

(defn stub-fn [the-function return-value]
  (swap! mock-calls assoc the-function [])
  (fn [& args]
    (swap! mock-calls update-in [the-function] conj args)
    return-value))

(defn mock-fn [the-function]
  (stub-fn the-function nil))

(defmacro verify-call-times-for [fn-name number]
  `(is (= ~number (count (@mock-calls ~(keyword fn-name))))))

(defmacro verify-first-call-args-for [fn-name & args]
  `(verify-nth-call-args-for 1 ~fn-name ~@args))

(defmacro verify-nth-call-args-for [n fn-name & args]
  `(is (= '~args (nth (@mock-calls ~(keyword fn-name)) (dec ~n)))))

(defn clear-calls []
  (reset! mock-calls {}))

(defmacro mocking [fn-names & body]
  (let [mocks (map #(list 'mock-fn (keyword %)) fn-names)]
    `(binding [~@(interleave fn-names mocks)]
      ~@body)))

(defmacro stubbing [stub-forms & body]
  (let [stub-pairs (partition 2 stub-forms)
        real-fns (map first stub-pairs)
        returns (map last stub-pairs)
        stub-fns (map #(list 'stub-fn %1 %2) real-fns returns)]
    `(binding [~@(interleave real-fns stub-fns)]
      ~@body)))