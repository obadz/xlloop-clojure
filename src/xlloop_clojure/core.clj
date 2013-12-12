(ns xlloop-clojure.core
  (:gen-class xlloop_clojure.core)
  (:require [xlloop_clojure.funs]))

(defn start-server []
  (let [fs   (org.boris.xlloop.FunctionServer.)
        rfh  (org.boris.xlloop.reflect.ReflectFunctionHandler.)
        firh (org.boris.xlloop.handler.FunctionInformationHandler.)
        cfh  (org.boris.xlloop.handler.CompositeFunctionHandler.)]
    (.addMethods rfh "Math."    java.lang.Math)
    (.addMethods rfh "Test."    (xlloop_clojure.funs.)) ; Use an object instance rather than the class because the methods aren't static
    (.add firh (.getFunctions rfh))
    (.add cfh rfh)
    (.add cfh firh)
    (.setFunctionHandler fs (org.boris.xlloop.handler.DebugFunctionHandler. cfh))
    (println "Listening on port "  (.getPort fs))
    (.run fs)))

(defn -main [& args]
  (start-server))
