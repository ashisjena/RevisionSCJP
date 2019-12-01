package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.old;

public interface ItemElement
{
    public int accept( ShoppingCartVisitor visitor );
}