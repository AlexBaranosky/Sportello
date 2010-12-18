(ns fact.collection-utils
  (:use midje.sweet)
  (:use collection-utils))

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

(fact "zips a list of pairs into two lists of items"
  (zip [[1 2] [3 4] [5 6] [7 8]]) => [[1 3 5 7] [2 4 6 8]])

(fact "zips a list of tuples into a list for each element in the original lists' tuples"
  (zip [[1 2 3] [4 5 6] [7 8 9] [10 11 12]]) => [[1 4 7 10] [2 5 8 11] [3 6 9 12]])

(fact "if I zip then zip again, I get the original back"
  (-> [[1 2] [3 4] [5 6] [7 8]] zip zip) => [[1 2] [3 4] [5 6] [7 8]])
