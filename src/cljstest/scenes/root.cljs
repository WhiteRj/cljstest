(ns cljstest.scenes.root
  (:require [cljstest.images :as images]
            [cljstest.ui :as ui]))

(def styles {:container  {:flex 1
                          :align-items :center
                          :justify-content :center}
             :text-hello {:font-size 22
                          :margin-top 50}})

(defn scene []
  [ui/view {:style (:container styles)}
   [ui/image {:source images/icon-cljs}]
   [ui/text {:style (:text-hello styles)} "Hello, World!"]])
