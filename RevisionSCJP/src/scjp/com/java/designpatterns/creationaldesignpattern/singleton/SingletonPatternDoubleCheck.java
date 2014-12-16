package scjp.com.java.designpatterns.creationaldesignpattern.singleton;

public final class SingletonPatternDoubleCheck
{
    private static volatile SingletonPatternDoubleCheck INSTANCE;
    
    private SingletonPatternDoubleCheck()
    {
        if(INSTANCE != null)
            throw new RuntimeException( "Singleton object is already intitialized" );
    }
    
    public static SingletonPatternDoubleCheck getInstance()
    {
        if(INSTANCE == null)
            synchronized (SingletonPatternDoubleCheck.class)
            {
                INSTANCE = new SingletonPatternDoubleCheck();
            }
        return INSTANCE;
    }
}
