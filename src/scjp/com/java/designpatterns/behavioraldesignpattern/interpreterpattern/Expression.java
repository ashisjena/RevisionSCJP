package scjp.com.java.designpatterns.behavioraldesignpattern.interpreterpattern;

public interface Expression
{
    String interpret( InterpreterContext ic );
}