Adapter pattern works as a bridge between two incompatible interfaces.

We use the adapter pattern when we use a client and a service. And we don't want two to know about each other. We want to insulate the client from the service and vice versa.

The client makes a request to the adapter by calling method on it using the target interface.
The adapter translates that request on the adaptee using the adaptee interface.


The object form of adapter pattern is more flexible(uses composition), as we can use setter of adapter to change the adaptee(ex. light) in the middle. It's complex.
The class form of adapter pattern is simple but is rigid(inheritance causes rigidity), as it binds to a single adaptee. It's faster and takes less memory.