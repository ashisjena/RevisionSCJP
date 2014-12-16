package scjp.com.java.designpatterns.creationaldesignpattern.singleton;


public final class SingletonPatternLazyHolder
{
    private static class LazyHolder
    {
        private static final SingletonPatternLazyHolder INSTANCE = new SingletonPatternLazyHolder();
    }

    public static SingletonPatternLazyHolder getInstance()
    {
        return LazyHolder.INSTANCE;
    }

    private SingletonPatternLazyHolder()
    {
        if ( getInstance() != null )
            throw new RuntimeException( "Singleton object is already intitialized" );
    }
}