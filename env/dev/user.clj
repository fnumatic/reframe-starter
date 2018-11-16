(ns user
  (:require [figwheel.main.api :as ra]))

(defn start [] (ra/start  "dev"))

(defn stopp [] (ra/stop-all))

(defn cljs [] (ra/cljs-repl "dev"))