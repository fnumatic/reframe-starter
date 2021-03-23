(ns ^:figwheel-hooks cljs-reframe-template.core
  (:require
   [reagent.dom :refer [render]]
   [re-frame.core :as re-frame]
   [cljs-reframe-template.use-cases.core-cases :as ccases]
   [cljs-reframe-template.routes :as routes]
   [cljs-reframe-template.views.home :as views]
   [cljs-reframe-template.config :as config]
   [cljs-reframe-template.styles :as styl]))



(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (println "mount")
  (re-frame/clear-subscription-cache!)
  (styl/inject-trace-styles js/document)
  (render [views/main-panel]
          (.getElementById js/document "app")))

(defn ^:after-load re-render []
  (mount-root))

(defn ^:export init []
  (println "init again..")
  (re-frame/dispatch-sync [::ccases/initialize-db])
  (dev-setup)
  (routes/app-routes)

  (mount-root))