package scjp.com.java.algorithm.datastructures.linkedlist;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/* Q1)Two Robots landed from a space-ship.The initial landing position of the space-ship is called'HOTSPOTS'.
      You need to implement the below method so that they meet.
      Note:Consider this below Main class is running parallel on both machines at the exact same time.There is no distinction between both robots.
      When both robots meet they can talk with each other and stop.i.e.the MainClass execution will stop on both machines.
      Ex.when you call right(5),both robots move 5steps right.

      Let's take the name of the robot on left as A and the robot on right as B. This is just for our understanding, the program doesn't know A and B.
      -----A-------B-------
*/
public class RobotsMeetCyclicLL {
  // Below are few already implemented methods

  // This method moves the robot to given steps right
  void right(int noOfSteps) {
    throw new NotImplementedException();
  }

  // This method moves the robot to given steps left
  void left(int noOfSteps) {
    throw new NotImplementedException();
  }

  // This method returns true when both the Robots are on same position.
  boolean isMet() {
    throw new NotImplementedException();
  }

  // This method returns true when the robot is on a hot-spot.
  boolean isHotSpot() {
    throw new NotImplementedException();
  }

  // This method needs to be implemented.
  public boolean makeTheRobotsMeet() {

    while (!this.isHotSpot()) {
      this.right(1);
    }
    // When A reaches B's initial position; A will come out of the loop. But B will be continuing with 1 step right.

    // Move 'A' faster by 2 steps. And B is still moving with 1 steps as per earlier loop
    // (Hint:Determining cyclic linked list through slow and fast pointers)

    while (!this.isMet()) {
      this.right(2);
    }

    return true;
  }
}
