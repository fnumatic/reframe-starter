(ns cljs-reframe-template.views.home
  (:require
    [re-frame.core :as re-frame]
    [cljs-reframe-template.use-cases.core-cases :as ccases]
    [tools.viewtools :as vt]
    [cljs.pprint :as pp]
    [cljs-reframe-template.views.compo :as compo]))


(defn main []
  [:div
   {:class ["h-[220px]" "w-[300px]" :bg-blue-50 :m-4 :p-2 "rounded-[5px]"]}
   [:h2.text-4xl "home"]
   [:p "nothing to see here"]])

(def toolbar-items
  [
   ["#" :routes/frontpage]
   ["component" :routes/component]])

(defn route-info [route]
  [:div.m-4
   [:p "Routeinfo"]
   [:pre.border-solid.border-2.rounded
    (with-out-str (pp/pprint route))]])
;; main

(defn show-panel [route]
  (when-let [route-data (:data route)]
    (let [view (:view route-data)]
      [:<>
       [view]
       [route-info route]])))

(defn main-panel []
  (let [active-route (re-frame/subscribe [::ccases/active-panel])]
    [:div
     [vt/navigation toolbar-items]
     [show-panel @active-route]]))
