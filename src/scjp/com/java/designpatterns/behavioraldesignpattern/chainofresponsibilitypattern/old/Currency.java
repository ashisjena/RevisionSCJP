package scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.old;

public class Currency
{
    private int amount;

    public Currency( int amt )
    {
        this.amount = amt;
    }

    public int getAmount()
    {
        return this.amount;
    }
}