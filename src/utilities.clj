(ns utilities
  (:import (java.io File)))

(defn lines [string]
  (seq (.split #"\r?\n" string)))