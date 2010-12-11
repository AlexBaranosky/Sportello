(ns utilities
  (:import (java.io File)))

(defn path-combine [path1 path2]
  (let [file1 (File. path1)
        file2 (File. file1 path2)]
    (.getPath file2)))

(defn current-dir []
  (.getCanonicalPath (File. ".")))

(def template-dir "C:\\dev\\sportellos\\templates")