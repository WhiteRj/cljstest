(ns react.ui-classes
  (:require [reagent.core :as r]
            [react.core :as react]))

(def text-input
  (r/adapt-react-class react/text-input))

(def text
  (r/adapt-react-class react/text))

(def touchable-without-feedback
  (r/adapt-react-class react/touchable-without-feedback))

(def touchable-opacity
  (r/adapt-react-class react/touchable-opacity))

(def touchable-highlight
  (r/adapt-react-class react/touchable-highlight))

(def touchable-native-feedback
  (r/adapt-react-class react/touchable-native-feedback))

(def image
  (r/adapt-react-class react/image))

(def activity-indicator
  (r/adapt-react-class react/activity-indicator))

(def view
  (r/adapt-react-class react/view))

(def scroll-view
  (r/adapt-react-class react/scroll-view))

(def list-view
  (r/adapt-react-class react/list-view))

(def refresh-control
  (r/adapt-react-class react/refresh-control))

(def status-bar
  (r/adapt-react-class react/status-bar))
