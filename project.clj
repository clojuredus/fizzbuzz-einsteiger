(defproject einsteiger "0.1.0-SNAPSHOT"
  :description "Erste Schritte mit Clojure"
  :url "http://clojure-duesseldorf.de"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :plugins [[nightlight/lein-nightlight "RELEASE"]]
  :repl-options {:init-ns einsteiger.core
                 :init (set! *print-length* 20)})