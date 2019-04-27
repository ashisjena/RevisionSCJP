package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern;

public interface ItemElement
{
    public int accept( ShoppingCartVisitor visitor );
}