(ns cljstest.events-fx
  (:require [re-frame.core :refer [reg-fx dispatch]]
            [utils.network :as network]))

(defn http-fetch-fx
  [{:keys [on-success on-failure]
    :as   request}]
  (network/fetch
    (cond-> request
            on-success (assoc :handler #(dispatch (conj on-success %)))
            on-failure (assoc :error-handler #(dispatch (conj on-failure %)))
            :also      (dissoc :on-success :on-failure))))

(reg-fx
  :http-fetch
  http-fetch-fx)
