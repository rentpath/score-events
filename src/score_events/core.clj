(ns score-events.core
  (:require [com.stuartsierra.component :as component]
            [clojure.core.async :as a]
            [score-events.event-ticker :as t]))



(defn ->application
  [event-chan]
  (component/system-map
    :event-ticker (t/->EventTicker event-chan 100)))

(defn start-system
  [event-chan]
  (let [system (->application event-chan)]
    (component/start-system system)
    system))