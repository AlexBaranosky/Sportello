(ns fact.collection-utils
  (:use google-maps)
  (:use midje.sweet)
  (:use collection-utils)
  (:use spec))

(fact "maps keys of two maps using given function"
  (fmap #(+ %1 %1 %2) {:a 1 :b 2} {:a 3 :b 4})
  => {:a 5 :b 8})

(fact "maps keys of two maps using given function"
  (fmap #(+ %1 %1 %2) {:a 1 :b 2} {:a 3 :b 4})
  => {:a 5 :b 8})

(fact "maps keys of three maps using given function"
  (fmap #(+ %1 %2 %3) {:a 1 :b 2} {:a 3 :b 4} {:a 5 :b 6})
  => {:a 9 :b 12})

(fact "maps keys of any number of maps using given function"
  (fmap #(+ %1 %2 %3 %4) {:a 1 :b 2} {:a 3 :b 4} {:a 5 :b 6} {:a 7 :b 8})
  => {:a 16 :b 20})

(fact "throws when no items"
  (only []) =>(throws RuntimeException "should have precisely one item, but had: 0"))

(fact "throws when more than one item"
  (only [1 2]) => (throws RuntimeException "should have precisely one item, but had: 2"))

(fact "gets values of distance for nested nested hash map"
  (values-of :distance {:goat "al" :distance 35})
  => [35])

(fact "gets values of distance for nested hash map with two children"
  (values-of :distance [{:goat "al" :distance 35}
                        {:goat "paula" :distance 25}])
  => [35, 25])

(fact "gets values of distance for doubly nested hash map"
  (values-of :distance [{:goat "al" :distance 35}
                        {:goat "paula" :distance 25 :other {:distance 99}}])
  => [35, 25, 99])

(fact "gets values of distance for triply nested hash map"
  (values-of :distance [{:goat "al" :distance 35}
                        {:goat "paula" :distance 25 :other {:distance 99 :another {:distance 77}}}])
  => [35, 25, 99, 77])

(fact "includes nils in results"
  (values-of :distance [{:goat "al" :distance 35}
                        {:goat "paula" :distance 25 :other {:notdistance 99 :another {:distance nil}}}])
  => [35, 25, nil])