package scjp.com.java.designpatterns.creationaldesignpattern.abstractfactorypattern;

public class ComputerFactory {
    
    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}