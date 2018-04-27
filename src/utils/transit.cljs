(ns utils.transit
  (:require [cognitect.transit :as transit]))

(def ^:local transit-reader
  (transit/reader :json))
(def ^:local transit-writer
  (transit/writer :json))

(def transit-read
  (partial transit/read transit-reader))
(def transit-write
  (partial transit/write transit-writer))
