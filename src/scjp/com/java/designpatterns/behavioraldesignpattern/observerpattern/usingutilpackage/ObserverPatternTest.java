package scjp.com.java.designpatterns.behavioraldesignpattern.observerpattern.usingutilpackage;


public class ObserverPatternTest
{
    public static void main( String[] args )
    {
        MyTopic topic = new MyTopic();
        topic.addObserver( new MyTopicSubscriber( topic, "Rama" ) );
        topic.addObserver( new MyTopicSubscriber( topic, "Raja" ) );
        topic.addObserver( new MyTopicSubscriber( topic, "Sita" ) );

        topic.setChanged();
        topic.notifyObservers( "Message" );
        
        System.out.println( "done" );

    }
}