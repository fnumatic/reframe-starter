(ns cljs-reframe-template.home
  (:require
    [re-frame.core :as re-frame]
    [cljs-reframe-template.subs :as subs]
    [cljs-reframe-template.viewtools :as vt]))



(defn main []
  [:div
   [:h2 "home"]
   [:p "nothing to see"]])


(def navitems
  [["#" :routes/frontpage]
   ["component" :routes/component]])


;; main

(defn show-panel [route]
  (if-let [view (:view (:data route))]
    [:div
     [view]
     [:pre (with-out-str (cljs.pprint/pprint route))]]))

(defn main-panel []
  (let [active-route (re-frame/subscribe [::subs/active-panel])]
    [:div
     [vt/navigation navitems]
     [show-panel @active-route]]))
