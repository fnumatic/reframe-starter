(ns ^:figwheel-hooks cljs-reframe-template.core
  (:require [cljs-reframe-template.config :as config]
            [cljs-reframe-template.routes :as routes]
            [cljs-reframe-template.styles :as styl]
            [cljs-reframe-template.use-cases.core-cases :as ccases]
            [cljs-reframe-template.views.home :as views]
            [goog.dom :as gdom]
            [react :as react]
            [re-frame.core :as re-frame]
            [reagent.dom.client :as rdc]))



(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defonce root (rdc/create-root (gdom/getElement "app")))

(defn mount-root []
  (println "mount")
  (re-frame/clear-subscription-cache!)
  (styl/inject-trace-styles js/document)
  (rdc/render root [:> react/StrictMode {} [#'views/main-panel]]))

(defn ^:after-load re-render []
  (mount-root))

(defn ^:export init []
  (println "init again..")
  (re-frame/dispatch-sync [::ccases/initialize-db])
  (dev-setup)
  (routes/app-routes)

  (mount-root))