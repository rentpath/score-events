(ns score-events.event-ticker
  (:require [clojure.core.async :as a]
            [com.stuartsierra.component :as component])
  (:import [java.util Timer TimerTask]))

(defn get-event
  []
  (rand-nth
    (concat
      (repeat 40 "PushEvent")
      (repeat 25 "PullRequestReviewCommentEvent")
      (repeat 5 "WatchEvent")
      (repeat 5 "CreateEvent")
      (repeat 2 "ForkEvent"))))

(defn enqueue-event
  [output-chan]
  (a/go
    (a/>! output-chan (get-event))))

(defrecord EventTicker
  [output-chan sweeper-delay]
  component/Lifecycle
  (start [this]
    (println "Ticker Starting")
    (let [timer (Timer.)
          task (proxy [TimerTask] []
                 (run [] (enqueue-event output-chan)))]

      (.schedule timer task sweeper-delay sweeper-delay)
      (assoc this :timer timer)))

  (stop [this]
    (println "Ticker stopping")
    (.cancel (:timer this))
    (dissoc this :timer)
    (println "Ticker stopped")))