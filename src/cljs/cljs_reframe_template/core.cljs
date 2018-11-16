(ns ^:figwheel-hooks cljs-reframe-template.core
  (:require
   [reagent.core :as reagent]
   [re-frame.core :as re-frame]
   [re-pressed.core :as rp]
   [cljs-reframe-template.events :as events]
   [cljs-reframe-template.routes :as routes]
   [cljs-reframe-template.home :as views]
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
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:after-load re-render []
  (mount-root))

(defn ^:export init []
  (println "init again..")
  (routes/app-routes)
  (re-frame/dispatch-sync [::events/initialize-db])
  (re-frame/dispatch-sync [::rp/add-keyboard-event-listener "keydown"])
  (dev-setup)

  (mount-root))

(defonce init-block (init))
