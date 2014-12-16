package scjp.com.java.designpatterns.behavioraldesignpattern.iteratorpattern;

public interface ChannelCollection
{
    public void addChannel( Channel c );

    public void removeChannel( Channel c );

    public ChannelIterator iterator( ChannelTypeEnum type );

}