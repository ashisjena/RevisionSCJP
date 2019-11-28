package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.normalApproach;

public interface ShoppingCartVisitor
{
    int visit( Book book );

    int visit( Fruit fruit );
}