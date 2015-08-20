# score-events

A Clojure library designed to ... well, that part is up to you.

## Usage

In this project we will be logging and scoring events.  

Events are scored based on this table.  

| Event Type | Points |
|------------|---|
| PushEvent  | 5 |
| PullRequestReviewCommentEvent | 4 |
| WatchEvent  | 3 |
| CreateEvent | 2 |
| Every other event | 1 |

## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
