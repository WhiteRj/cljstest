(ns react.listview
  (:require [react.core :as react]))

(defn data-source [config]
  (react/list-view-ds. (clj->js config)))

(defn to-js-list [data]
  (let [js-list #js []]
    (doseq [item data]
      (.push js-list item))
    js-list))

(defn to-js-dict [data]
  (let [js-dict #js {}]
    (doseq [[k v] data]
      (aset js-dict k (to-js-list v)))
    js-dict))

(defn clone-with-rows [ds rows]
  (.cloneWithRows ds (to-js-list rows)))

(defn clone-with-rows-and-sections [ds rows sections]
  (.cloneWithRowsAndSections ds (to-js-dict rows) (clj->js sections)))

(defn to-datasource [items]
  (-> (data-source {:rowHasChanged not=})
      (clone-with-rows items)))

(defn to-sectioned-datasource
  ([items]
    (to-sectioned-datasource items (keys items)))
  ([items keys]
   (-> (data-source {:rowHasChanged not=
                     :sectionHeaderHasChanged not=})
       (clone-with-rows-and-sections items keys))))
