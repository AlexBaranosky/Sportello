(ns collecton-utils-facts
  (:use google-maps)
  (:use collection-utils)
  (:use midje.sweet))

(fact
  (multi-fmap #(+ %1 %1 %2 ) {:a 1 :b 2} {:a 3 :b 4}) => {:a 5 :b 8})

(fact
  (multi-fmap #(+ %1 %2 %3 ) {:a 1 :b 2} {:a 3 :b 4} {:a 5 :b 6}) => {:a 9 :b 12} )

(fact
  (multi-fmap #(+ %1 %2 %3 %4 ) {:a 1 :b 2} {:a 3 :b 4} {:a 5 :b 6} {:a 7 :b 8}) => {:a 16 :b 20} )

;(fact ;'only' throws if there are no items
;  (only []))

(fact
  (values-of :distance {:goat "al" :distance 35})
  => [35])

(fact
  (values-of :distance [{:goat "al" :distance 35}
                        {:goat "paula" :distance 25}])
  => [35, 25])

(fact
  (values-of :distance [{:goat "al" :distance 35}
                        {:goat "paula" :distance 25 :other {:distance 99}}])
  => [35, 25, 99])

(fact
  (values-of :distance [{:goat "al" :distance 35}
                        {:goat "paula" :distance 25 :other {:distance 99 :another {:distance 77}}}])
  => [35, 25, 99, 77])

(fact
  (values-of :distance [{:goat "al" :distance 35}
                        {:goat "paula" :distance 25 :other {:notdistance 99 :another {:distance 77}}}])
  => [35, 25, 77])

(fact
  (values-of :distance [{:goat "al" :distance 35}
                        {:goat "paula" :distance 25 :other {:notdistance 99 :another {:distance nil}}}])
  => [35, 25, nil])
