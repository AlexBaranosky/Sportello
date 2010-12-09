(ns facts.spec_specs
  (:use clojure.test))

(deftest defspec-exception0-msg-expands-properly
  (is
    (= " (facts.specspecs/defspec-exception-msg facts.specspecs/throws-when-no-items java.lang.RuntimeException #\" should have precisely one item, but had: 0 \" (facts.specspecs/only [])) 5))")))
(macroexpand-1 `(defspec-exception-msg throws-when-no-items
  RuntimeException #" should have precisely one item, but had: 0 "
  (only [])))

(run-tests)


