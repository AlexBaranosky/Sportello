(ns templates
  (import [org.antlr.stringtemplate StringTemplate]))

(defn template [#^String txt #^java.util.Map context]
  (let [t (StringTemplate. txt)]
    (.setAttributes t context)
    (.toString t)))

(print (template "Hello $user$. Today is $date$" {"user" "Joe" "date" 123}))