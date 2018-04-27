(ns react.platform
  (:require [react.core :as react]))

(def screen-dimensions
  (react/dimensions-get "screen"))
(def screen-width
  (aget screen-dimensions "width"))
(def screen-height
  (aget screen-dimensions "height"))

(def platform-os      (aget react/platform "OS"))
(def platform-version (aget react/platform "Version"))
(def ios?      (= platform-os "ios"))
(def android?  (= platform-os "android"))
(def android4? (and android? (<= platform-version 20)))
(def android5? (and android? (>= platform-version 21)))
