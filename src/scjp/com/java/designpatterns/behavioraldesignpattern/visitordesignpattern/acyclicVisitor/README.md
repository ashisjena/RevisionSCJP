Acyclic Visitors are bit complicated.

When not to Use:
-----------------
180 degree rotation from derivates to base classes.

Time taken to do the type check.

Violates Liskov's Principle.

And if there are less possibilities of adding new derivatives then no advantage at all.

When to Use:
------------
Adding more derivates to the visited hierarchy.

And when the visiting matrix is sparse. i.e Visited hierarchy(Modem) vs Visiting hierarchy
if the Unix visitor is used then the type check in the Modem derivatives will fail.

|    |  Unix    | OSX     |
|---:|:--------:|:--------|
|Hayos|Configure Hayos for Unix|Configure Hayos for OSX|
|USR|Configure USR for Unix|Configure USR for OSX|
|Zoom|   XXX    |Configure Zoom for OSX|
