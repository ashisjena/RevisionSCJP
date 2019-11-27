The STATE interface will contain the EVENT methods and the FSM(State Machine) as the method parameter.

An ENUM will implement the STATE interface and will use the FSM object to set the next state and invoke an action of the FSM.

The FSM will contain the setState() and public methods defining the EVENTS that will call the current state event method by passing itSelf.
and will contain the abstract actions

A concrete implementation to the abstract FSM will implement the action methods.