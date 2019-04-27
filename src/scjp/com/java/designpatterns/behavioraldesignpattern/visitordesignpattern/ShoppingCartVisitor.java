package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern;

public interface ShoppingCartVisitor
{
    int visit( Book book );

    int visit( Fruit fruit );
}