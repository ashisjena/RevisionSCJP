package scjp.com.java.designpatterns.behavioraldesignpattern.mediatorpattern.old;

public interface ChatMediator
{
    public void sendMessage( String msg, User user );

    void addUser( User user );
}