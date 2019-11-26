State Pattern separates WHAT from HOW.

GIVEN a particular State WHEN an Event occurs, THEN it transitions to other state by INVOKING the specified action. 

|GIVEN STATE|  EVENT   |NEXT STATE|  ACTION  |
|:---------:|:--------:|:--------:|:--------:|
|Locked     |    Coin  |  Unlocked|  Unlock  |
|Locked     |    Pass  |  Locked  |  Alarm   |
|Unlocked   |    Pass  |  Locked  |  Lock    |
|Unlocked   |    Coin  |  Unlocked|  Thanks  |