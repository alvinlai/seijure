(ns seijure.core
  (:use compojure.core
        ring.adapter.jetty
        ring.middleware.reload
        hiccup.core
        cheshire.core)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]))

(defn footer-layout
  []
  (html
    [:div#footer "Copyright 2011"]))

(defn default-layout
  [body]
  (html
    [:div#content body]
    (footer-layout)))

; (defn handler
;   [req]
;   {:status 200
;    :headers {"Content-Type" "text/html"}
;    :body (generate-string {:foo "bar" :baz 5})})
; 
; (defn boot
;   []
;   (run-jetty
;     (wrap-reload
;         #'handler '(seijure.core))
;         {:port 5000}))

(defn json-result
  [data]
  (generate-string 
    {:a "apple"
     :b "banana"}))

(defroutes my-routes
  (GET "/" [] "Hello gee")
  (GET "/hi/:name" 
    [name] 
    (default-layout (str "Hello " name)))
  (POST "/post/:val"
    [val]
    (default-layout (str "Post value was " val)))
  (GET "/json-results" [] (json-result [1 2 3]))
  (route/not-found (default-layout "Page not found.")))

(def app (handler/site my-routes))