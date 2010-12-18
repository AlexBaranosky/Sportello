(ns string-utils
  (:use collection-utils)
  (:require [clojure.string :as str])
  (:import (java.io File)))

(defn split-lines [string]
  (seq (.split #"\r?\n" string)))

(defn remove-whitespace [s]
  (str/replace s #"\s" ""))

(defn split-into-columns [text divider]
  (->> text
       split-lines
       (map #(.split % divider))
       zip))