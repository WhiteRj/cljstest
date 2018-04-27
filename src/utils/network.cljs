(ns utils.network
  (:require [utils.transit :refer [transit-read]]))

(def str-transit
  "application/transit+json")
(def str-json
  "application/json")
(def str-form
  "multipart/form-data")

(defn fetch
  [{:keys [uri method headers body format handler error-handler timeout]
    :or   {method   :get
           format   :transit}}]
  (let [headers (merge (when body {:content-type (case format
                                                   :transit str-transit
                                                   :json    str-json
                                                   :form    str-form)})
                       {:accept (case format
                                  :transit str-transit
                                  :json    str-json
                                  :form    str-transit)}
                       headers)
        body    (when body (case format
                             :transit (-> body clj->js js/JSON.stringify)
                             :json    (-> body clj->js js/JSON.stringify)
                             :form    body))]

    (-> (js/fetch uri #js {:method   (name method)
                           :headers  (clj->js headers)
                           :body     body})
        (.then (fn [resp]
                 (-> (.text resp)
                     (.then (fn [text]
                              (let [ok          (aget resp "ok")
                                    status      (aget resp "status")
                                    status-text (aget rest "statusText")
                                    data        (when text (transit-read text))
                                    result      {:ok          ok
                                                 :status      status
                                                 :status-text status-text
                                                 :data        data}]
                                (if ok
                                  (when handler (handler result))
                                  (throw result))))))))
        (.catch (fn [resp]
                  (let [result (if (map? resp)
                                 (assoc resp :error true)
                                 {:ok false :error resp})]
                    (when error-handler (error-handler result))))))))
