package scjp.com.java.designpatterns.creationaldesignpattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SabotoseSingleton
{
    public static void main( String[] args ) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        SingletonPatternLazyHolder object1 = SingletonPatternLazyHolder.getInstance();
        SingletonPatternLazyHolder object2 = null;

        Constructor[] constructors = SingletonPatternLazyHolder.class.getDeclaredConstructors();

        //below code will destroy the singleton pattern
        for ( Constructor constructor : constructors )
        {
            //Below code will destroy the singleton pattern
            constructor.setAccessible( true );
            object2 = (SingletonPatternLazyHolder)constructor.newInstance();
            break;
        }
        
        System.out.println(object1.hashCode());
        System.out.println(object2.hashCode());
    }
}
