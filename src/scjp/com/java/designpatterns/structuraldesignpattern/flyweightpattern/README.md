This is used when a large no of objects that can share a certain amount of fixed state.

A flyweight objects essentially has two kind of attributes – intrinsic and extrinsic.

An INTRINSIC state attribute is stored/shared in the flyweight object, and it is independent of flyweight’s context. As the best practice, we should make intrinsic states immutable.

An EXTRINSIC state varies with flyweight’s context, which is why they cannot be shared. Client objects maintain the extrinsic state, and they need to pass this to a flyweight object during object creation.

Example: Suppose we have a pen which can exist with/without refill. A refill can be of any color thus a pen can be used to create drawings having N number of colors.
         Here Pen can be flyweight object with refill as extrinsic attribute. All other attributes such as pen body, pointer etc. can be intrinsic attributes which will be common to all pens. A pen will be distinguished by its refill color only, nothing else.