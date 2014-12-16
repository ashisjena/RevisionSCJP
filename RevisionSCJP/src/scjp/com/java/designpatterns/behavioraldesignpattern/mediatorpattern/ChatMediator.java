package scjp.com.java.designpatterns.behavioraldesignpattern.mediatorpattern;

public interface ChatMediator
{
    public void sendMessage( String msg, User user );

    void addUser( User user );
}