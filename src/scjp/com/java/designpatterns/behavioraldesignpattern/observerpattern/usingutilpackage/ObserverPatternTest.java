package scjp.com.java.designpatterns.behavioraldesignpattern.observerpattern.usingutilpackage;


public class ObserverPatternTest
{
    public static void main( String[] args )
    {
        MyTopic topic = new MyTopic();
        topic.addObserver( new MyTopicSubscriber( "Rama" ) );
        topic.addObserver( new MyTopicSubscriber( "Raja" ) );
        topic.addObserver( new MyTopicSubscriber( "Sita" ) );

        topic.setChanged();
        topic.notifyObservers( "Message" );
        
        System.out.println( "done" );

    }
}