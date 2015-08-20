(ns score-events.core
  (:require [com.stuartsierra.component :as component]
            [clojure.core.async :as a]
            [score-events.event-ticker :as t]))



(defn ->application
  [event-chan]
  (component/system-map
    :event-ticker (t/->EventTicker event-chan 100)))

(def start-system (comp component/start-system ->application))
