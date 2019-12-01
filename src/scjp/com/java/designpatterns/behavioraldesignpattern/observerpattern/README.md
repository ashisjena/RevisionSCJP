Simple and formal way to create callbacks.

* Push model
* Pull model

You use the pull model when you are worried about small things or time inconsistency.

The Push model is used when you have large data sends and you wish to push a hint.
Because more complicated the data becomes then we need to push kind of hint to notify what kind if data has changed.

If the data you are observing is really small then, just push the data, rather notifying and the pulling the data by the observer.
In push model by the time the data reaches the observer, it can be inconsistent or stale. But the pull model queries real time data.