(ns cljs-reframe-template.routes
  (:require
    [re-frame.core :as rf]
    [reitit.frontend :as rtf]
    [reitit.frontend.history :as rtfh]
    [reitit.frontend.easy :as rtfe]
    [reitit.coercion.schema :as rsc]
    [cljs-reframe-template.use-cases.core-cases :as ccases]))


(def routes
    (rtf/router
      ["/"
       [""
        {:name :routes/frontpage}]
       ["component"
        {:name :routes/component}]]

      {:data {:coercion rsc/coercion}}))



(defn app-routes []

  (rtfe/start! routes
               (fn [m] (rf/dispatch [::ccases/set-active-panel m]))
               {:use-fragment true}))



