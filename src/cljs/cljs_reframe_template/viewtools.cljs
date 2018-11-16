(ns cljs-reframe-template.viewtools
  (:require [reitit.frontend.easy :as rtfe]))


(defn item [e]
  (cond
     (fn? e) [e]
     (vector? e) e
     (string? e) [:h2 e]))

(defn panel [name component]
  [:div

   [item name]
   [item component]])

;; navigation tools
(defn sep []
  [:span " | "])

(defn nav-item [i]
  (if (= :sep i)
    [sep]
    [:a {:href (rtfe/href (second i))} (first i)]))

(defn navigation [routes]
  (let [coll (->> routes (interpose :sep) (map-indexed vector))]
    [:div
     (for [[idx rt]  coll]
        ^{:key (str idx)} [nav-item rt])]))