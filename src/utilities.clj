(ns utilities
  (:require [clojure.string :as str])
  (:import (java.io File)))

(defn lines [string]
  (seq (.split #"\r?\n" string)))

(defn remove-whitespace [s]
  (str/replace s #" " ""))