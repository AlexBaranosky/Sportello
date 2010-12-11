(ns templates
  (import [org.antlr.stringtemplate StringTemplate]))

(defn template [#^String txt #^java.util.Map context]
  (-> (StringTemplate. txt) (.setAttributes context) str))

(print (template "Hello $user$. Today is $date$" {"user" "Joe" "date" 123}))