package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.old;

public interface ShoppingCartVisitor
{
    int visit( Book book );

    int visit( Fruit fruit );
}