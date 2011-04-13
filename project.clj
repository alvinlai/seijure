(defproject seijure "1.0.0-SNAPSHOT"
  :description "Seijure is a quickstart Clojure/Compojure project with pre-installed JSON capabilities"
  :dependencies [[org.clojure/clojure "1.2.1"]
                 ;[org.clojure/clojure-contrib "1.2.1"]
                 [compojure "0.6.2"]
                 [ring/ring-core "0.3.7"]
                 [ring/ring-jetty-adapter "0.3.7"]
                 [hiccup "0.3.4"]
                 [cheshire "1.1.0"]]
  :dev-dependencies [[ring/ring-devel "0.3.7"]
                     [lein-ring "0.4.0"]]
  :ring {:handler seijure.core/app})