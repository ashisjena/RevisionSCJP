The Memento Pattern is used when an object surrenders a private record of its internal state to some other part of the system. 
The system may hold on to that record for a time and then may hand it back to the originating object which will reconstitute 
itself from the recorded state. Alternatively, the system may create a new object from the recorded state. 
In any case, the recorded state remains private to the originating client.