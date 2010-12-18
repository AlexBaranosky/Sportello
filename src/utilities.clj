(ns utilities
  (:require [clojure.string :as str])
  (:import (java.io File)))

(defn split-lines [string]
  (seq (.split #"\r?\n" string)))

(defn remove-whitespace [s]
  (str/replace s #"\s" ""))