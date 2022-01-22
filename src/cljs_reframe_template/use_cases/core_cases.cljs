(ns cljs-reframe-template.use-cases.core-cases
  (:require
   [re-frame.core :as re-frame]
   [cljs-reframe-template.db :as db]
   [tools.reframetools :refer [sdb gdb]]))
   ;[day8.re-frame.tracing :refer-macros [fn-traced defn-traced]]))



(re-frame/reg-sub ::name (gdb [:name]))
(re-frame/reg-sub ::re-pressed-example  (gdb [:re-pressed-example]))

(re-frame/reg-event-db ::initialize-db (constantly db/default-db))


