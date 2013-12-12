(defproject xlloop-clojure "0.1.0-SNAPSHOT"
            :description "FIXME: write description"
            :url "http://example.com/FIXME"
            :license {:name "Eclipse Public License"
                      :url "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[org.clojure/clojure "1.5.1"]
                           ; installed with the help of http://www.elangocheran.com/blog/2013/03/installing-jar-files-locally-for-leiningen-2/
                           ; mvn install:install-file -Durl=file:repo -DgroupId=local -DartifactId=xlloop -Dversion=0.3.2 -Dpackaging=jar -Dfile=xlloop-0.3.2.jar
                           [local/xlloop "0.3.2"]]
            :aot :all
            :main xlloop_clojure.core
            :repositories {"project" "file:repo"})
