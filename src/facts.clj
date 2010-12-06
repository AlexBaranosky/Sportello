(ns facts
  (:use google-maps)
  (:use collection-utils)
  (:use midje.sweet))

(fact ;gets distance between two cities, in miles
  (dist-in-miles "NewYork,NY" "Boston,MA") => 219.061928254832)

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
