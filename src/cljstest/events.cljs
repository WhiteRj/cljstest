(ns cljstest.events
  (:require [re-frame.core :refer [reg-event-db]]
            [cljstest.db :refer [app-db]]))

(reg-event-db
  :initialize-db
  (fn [_ _]
    app-db))
