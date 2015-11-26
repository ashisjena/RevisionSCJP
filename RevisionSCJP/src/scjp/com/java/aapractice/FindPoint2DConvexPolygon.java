package scjp.com.java.aapractice;

// Q) determine if a point is inside a 2D convex polygon

/*
 * Solution 1) Draw a horizontal line to the right of each point and extend it to infinity
 * 
 * 2) Count the number of times the line intersects with polygon edges.
 * 
 * 3) A point is inside the polygon if either count of intersections is odd or point lies on an edge
 * of polygon. If none of the conditions is true, then point lies outside.
 */

public class FindPoint2DConvexPolygon {

  public static void main(String[] args) {
    Point[] points = {new Point(0, 0), new Point(10, 0), new Point(10, 10), new Point(0, 10)};

    if (isInside(points, new Point(20, 20)))
      System.out.println("Yes Inside");
    else
      System.out.println("Not Inside");

    if (isInside(points, new Point(5, 5)))
      System.out.println("Yes Inside");
    else
      System.out.println("Not Inside");
  }

  // Given three colinear points p, q, r, the function checks if
  // point q lies on line segment 'pr'
  static boolean onSegment(Point p, Point q, Point r) {
    if (q.x <= Math.max(p.x, r.x) && 
        q.x >= Math.min(p.x, r.x) && 
        q.y <= Math.max(p.y, r.y) && 
        q.y >= Math.min(p.y, r.y))
      return true;
    return false;
  }

  // To find orientation of ordered triplet (p1, p2, p3).
  // The function returns following values
  // 0 --> p1, p2 and p3 are colinear
  // 1 --> Clockwise
  // 2 --> Counterclockwise
  static int orientation(Point p1, Point p2, Point p3) {
    int val = (p2.y - p1.y) * (p3.x - p2.x) - (p2.x - p1.x) * (p3.y - p2.y);

    if (val == 0)
      return 0; // colinear
    return (val > 0) ? 1 : 2; // clock or counterclock wise
  }

  // The function that returns true if line segment 'curr next'
  // and 'point extreme' intersect. 
  static boolean doIntersect(Point curr, Point next, Point point, Point extreme) {
    // Find the four orientations needed for general and
    // special cases
    int o1 = orientation(curr, next, point);
    int o2 = orientation(curr, next, extreme);
    int o3 = orientation(point, extreme, curr);
    int o4 = orientation(point, extreme, next);

    // General case
    if (o1 != o2 && o3 != o4)
      return true;

    // Special Cases
    // curr, next and point are colinear and point lies on segment curr next
    if (o1 == 0 && onSegment(curr, point, next))
      return true;

    // p1, q1 and p2 are colinear and q2 lies on segment p1q1
    // as we are passing q2 as infinity point this will not occur
    if (o2 == 0 && onSegment(curr, extreme, next))
      return true;

    // p2, q2 and p1 are colinear and p1 lies on segment p2q2
    if (o3 == 0 && onSegment(point, curr, extreme))
      return true;

    // p2, q2 and q1 are colinear and q1 lies on segment p2q2
    if (o4 == 0 && onSegment(point, next, extreme))
      return true;

    return false; // Doesn't fall in any of the above cases
  }

  // Returns true if the point p lies inside the polygon[] with n vertices
  static boolean isInside(Point polygon[], Point p) {
    // There must be at least 3 vertices in polygon[]
    if (polygon.length < 3)
      return false;

    // Create a point for line segment from p to infinite
    Point extreme = new Point(Integer.MAX_VALUE, p.y);

    // Count intersections of the above line with sides of polygon
    int count = 0;
    for (int i = 0, next = 1; i < polygon.length; i++, next++) {
      if (next == polygon.length)  // Next point will be the starting point
        next = 0;


      // Check if the line segment from 'p' to 'extreme' intersects
      // with the line segment from 'polygon[i]' to 'polygon[next]'
      if (doIntersect(polygon[i], polygon[next], p, extreme)) { 
        // If the point 'p' is colinear with line segment 'i-next',
        // then check if it lies on segment. If it lies, return true,
        // otherwise false
        if (orientation(polygon[i], p, polygon[next]) == 0)
          return onSegment(polygon[i], p, polygon[next]);

        count++;
      }
    }

    // Return true if count is odd, false otherwise
    return count % 2 == 1;
  }
}


class Point {
  int y;
  int x;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}


