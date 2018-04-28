(ns cljstest.core
  (:require [reagent.core :as r]
            [re-frame.core :refer [dispatch-sync]]
            [react.core :as react]
            [cljstest.events]
            [cljstest.events-fx]
            [cljstest.subs]
            [cljstest.scenes.root :as root]))

(defn app-root []
  root/scene)

(defn init []
  (dispatch-sync [:initialize-db])
  (.registerComponent react/app-registry "cljstest" #(r/reactify-component app-root)))
