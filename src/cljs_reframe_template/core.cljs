(ns ^:figwheel-hooks cljs-reframe-template.core
  (:require [cljs-reframe-template.config :as config]
            [cljs-reframe-template.routes :as routes]
            [cljs-reframe-template.styles :as styl]
            [cljs-reframe-template.use-cases.core-cases :as ccases]
            [cljs-reframe-template.views.home :as views]
            [goog.dom :as gdom]
            [re-frame.core :as re-frame]
            [reagent.core :as r]
            ["react-dom/client" :refer [createRoot]]))



(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defonce root (createRoot (gdom/getElement "app")))

(defn mount-root []
  (println "mount")
  (re-frame/clear-subscription-cache!)
  (styl/inject-trace-styles js/document)
  (.render root (r/as-element [views/main-panel])))

(defn ^:after-load re-render []
  (mount-root))

(defn ^:export init []
  (println "init again..")
  (re-frame/dispatch-sync [::ccases/initialize-db])
  (dev-setup)
  (routes/app-routes)

  (mount-root))