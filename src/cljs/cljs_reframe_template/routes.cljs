(ns cljs-reframe-template.routes
  (:require
    [re-frame.core :as rf]
    [reitit.frontend :as rtf]
    [reitit.frontend.history :as rtfh]
    [reitit.frontend.easy :as rtfe]
    [reitit.coercion.schema :as rsc]
    [cljs-reframe-template.use-cases.core-cases :as ccases]
    [cljs-reframe-template.views.home :as home]
    [cljs-reframe-template.views.compo :as compo]))

;;https://clojure.org/guides/weird_characters#__code_code_var_quote
(def routes
    (rtf/router
      ["/"
       [""
        {:name :routes/frontpage
         :view #'home/main}]
       ["component"
        {:name :routes/component
         :view #'compo/main}]]

      {:data {:coercion rsc/coercion}}))



(defn app-routes []

  (rtfe/start! routes
               (fn [m] (rf/dispatch [::ccases/set-active-panel m]))
               {:use-fragment true}))



