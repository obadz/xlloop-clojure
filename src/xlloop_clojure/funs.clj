(ns xlloop-clojure.funs
  (:gen-class
    :name xlloop_clojure.funs
    :methods [[myTest  [] String]
              [myAdder [Number Number] Number]]))

(defn -myTest  [this] "yo")
(defn -myAdder [_ x y] (+ x y))
