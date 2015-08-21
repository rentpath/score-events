# score-events

In this project we will be computing "score-cards" for Github users and presenting their score in a web page.

The events are generated by the EventTicker component in the event-ticker namespace. We've defined various weights for different event types ([see table below](https://github.com/rentpath/score-events/tree/readme-tweaks#event-scoring)). Your task is to display a user's score-card in a web UI.

## Usage
To kick the process off, call `core.start-system`, passing in a core.async channel. Events will be put on that channel as they are generated.

## Goals
- Use [component](https://github.com/stuartsierra/component) library to start and stop the system.
- Compute aggregate scores for each github user, using the [table provided below](https://github.com/rentpath/score-events/tree/readme-tweaks#event-scoring).
- Display users' github score in a web-page.
- Log event activity to a sink of your choosing (stdout / log-file / log-store / wherever)

## Stretch Goals (choose your own adventure (or two))

### Live updates in browser
Reflect changes in DOM without user having to refresh page.

### Replace mock event source with actual Github event source.
Using this format `https://api.github.com/users/:user/events`, you can acquire recent activity for a github user.
Maybe you'd like to crunch the numbers of some prominent clojure hackers?

### Add a persistence layer
Persist state across system restarts.

### User authentication/authorization
A user should only be able to see his/her own score-card.

## Event scoring

Events are scored based on this table.  

| Event Type | Points |
|------------|---|
| PushEvent  | 5 |
| PullRequestReviewCommentEvent | 4 |
| WatchEvent  | 3 |
| CreateEvent | 2 |
| Every other event | 1 |




## License

Copyright © 2015 RentPath

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
