package scjp.com.java.designpatterns.structuraldesignpattern.adapterpattern.old;

public interface SocketAdapterInterface {
    
    public Volt get240Volt();
         
    public Volt get12Volt();
     
    public Volt get3Volt();
}