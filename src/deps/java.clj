(ns deps.java
   (:refer-clojure :exclude [compile])
   (:require [badigeon.javac :as javac]
             [badigeon.classpath :as classpath]))

(defn compile [{:keys [source-path output-path aliases]
                :or {aliases []}}]
  (javac/javac source-path
               {:compile-path output-path
                :javac-options ["-cp" (classpath/make-classpath {:aliases aliases})
                                "-target" "8" "-source" "8"
                                "-Xlint:-options"]})
  (println "Java Compilation Completed"))
