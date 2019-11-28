package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.normalApproach;

public interface ItemElement
{
    public int accept( ShoppingCartVisitor visitor );
}