# score-events

A Clojure library designed to have some fun with core.async.

## About

In this project we will be computing "score-cards" for Github users and presenting their score in a web page.

The events are generated by the EventTicker component in the event-ticker namespace. We've defined various weights for different event types (see table below). 

## Usage
To kick the process off, call `core.start-system`, passing in a core.async channel. Events will be put on that channel as they are generated.

## Goals
- Use `component` library to start and stop the system.
- Compute aggregate scores for each github user, using the table provided below.
- Display users' github score in a web-page.
- Log event activity to a sink of your choosing (STDOUT / log file / log store, whatever)

## Stretch Goals (choose your own adventure!)
If you've cleared the first set of goals and are hungry for more, take some hammock time to consider how you'd reach one of the stretch goals listed below.
We're interested in how you'd architect your solution, but if you feel like coding a solution, we won't stop you.

### Live updates in browser
Reflect changes in DOM without user having to refresh page

### Replace mock event source with actual Github event source.
Using this format `https://api.github.com/users/:user/events`, you can acquire recent activity for a github user.
Maybe you'd like to crunch the numbers of some prominent clojure hackers?

### User session management
Maybe a user should only be able to see his/her own score-card?

### [Define your own]
It's your system -- go wild!
some ideas:
- use datascript to manage client state
- replace leiningen with boot-clj
- statistical analysis of contributions -- who's busy when?


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
