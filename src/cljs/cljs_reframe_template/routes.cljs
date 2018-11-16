(ns cljs-reframe-template.routes
  (:require
    [re-frame.core :as rf]
    [reitit.frontend :as rtf]
    [reitit.frontend.easy :as rtfe]
    [reitit.coercion.schema :as rsc]
    [cljs-reframe-template.events :as events]
    [cljs-reframe-template.home :as home]
    [cljs-reframe-template.views.comp1 :as comp1]))


(def routes
    (rtf/router
      ["/"
       [""
        {:name :routes/frontpage
         :view home/main}]
       ["component"
        {:name :routes/component
         :view comp1/main}]]


      {:data {:coercion rsc/coercion}}))

(defn app-routes []
  (rtfe/start! routes
               (fn [m] (rf/dispatch [::events/set-active-panel m]))
               {:use-fragment true}))



