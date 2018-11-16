(ns cljs-reframe-template.events
  (:require
   [re-frame.core :as re-frame]
   [cljs-reframe-template.db :as db]))
   ;[day8.re-frame.tracing :refer-macros [fn-traced defn-traced]]))


(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-db
 ::set-active-panel
 (fn [db [_ active-panel]]
   (assoc db :active-panel active-panel)))

(re-frame/reg-event-db
 ::set-re-pressed-example
 (fn [db [_ value]]
   (assoc db :re-pressed-example value)))
