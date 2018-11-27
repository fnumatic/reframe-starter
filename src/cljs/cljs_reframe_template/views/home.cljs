(ns cljs-reframe-template.views.home
  (:require
    [re-frame.core :as re-frame]
    [cljs-reframe-template.use-cases.core-cases :as ccases]
    [tools.viewtools :as vt]
    [cljs-reframe-template.views.compo :as compo]))


(defn main []
  [:div
   [:h2 "home"]
   [:p "nothing to see here"]])

(def toolbar-items
  [
   ["#" :routes/frontpage]
   ["component" :routes/component]])


(def components
  {:routes/frontpage main
   :routes/component compo/main})

;; main

(defn show-panel [route]
  (when-let [route-data (:data route)]
    (let [view (->> route-data
                    :name
                    (get components))]
      [:<>
       [view]
       [:pre (with-out-str (cljs.pprint/pprint route))]])))

(defn main-panel []
  (let [active-route (re-frame/subscribe [::ccases/active-panel])]
    [:div
     [vt/navigation toolbar-items]
     [show-panel @active-route]]))
