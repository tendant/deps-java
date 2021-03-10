(ns deps.java
  ;; (:refer-clojure :exclude [compile])
  (:require [badigeon.javac :as bjavac]
            [badigeon.classpath :as classpath]))

(defn javac [{:keys [source-path output-path source-version target-version aliases]
                :or {aliases []
                     source-path "java"
                     output-path "target/classes"
                     source-version "8"
                     target-version "8"}}]
  (bjavac/javac source-path
                {:compile-path output-path
                 :javac-options ["-cp" (classpath/make-classpath {:aliases aliases})
                                 "-target" target-version "-source" source-version
                                 "-Xlint:-options"]})
  (println "Java Compilation Completed"))
