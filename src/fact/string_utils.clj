(ns fact.string-utils
  (:use string-utils)
  (:use midje.sweet))

(fact "splits a string into a vector of each line"
  (split-lines "one \ntwo \nthree ") => ["one " "two " "three "])

(fact "removes all whitespace from given string"
  (remove-whitespace "\t\n\r  ") => "")

(fact "splits a seq of pairs (on the given delimiter) into two vectors"
  (split-into-columns "google:50\nmicrosoft:55" ":") => [["google" "microsoft"] ["50" "55"]])

(fact "splits a string of delimited chunks into a vector for each column"
  (split-into-columns "google,50,excellent\nmicrosoft,55,nifty" ",")
  => [["google" "microsoft"] ["50" "55"] ["excellent" "nifty"]])