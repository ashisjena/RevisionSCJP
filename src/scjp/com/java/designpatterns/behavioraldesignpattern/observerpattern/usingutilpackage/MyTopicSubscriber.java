package scjp.com.java.designpatterns.behavioraldesignpattern.observerpattern.usingutilpackage;

import java.util.Observable;
import java.util.Observer;

public class MyTopicSubscriber implements Observer {
  private Object name;

  public MyTopicSubscriber(String name) {
    this.name = name;
  }

  @Override
  public void update(Observable o, Object arg) {
    System.out.println(name + ", " + arg + ", ");
  }
}