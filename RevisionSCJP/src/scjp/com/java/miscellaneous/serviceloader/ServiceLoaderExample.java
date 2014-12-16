package scjp.com.java.miscellaneous.serviceloader;

import java.util.ServiceLoader;

import scjp.com.java.miscellaneous.serviceloader.Parent;

public class ServiceLoaderExample
{
    public static void main( String[] args )
    {
        ServiceLoader< Parent > serviceLoader = ServiceLoader.load( Parent.class );

        for ( Parent parent : serviceLoader )
        {
            System.out.println( parent.method() );
        }
    }
}


// META-INF configuration is needed 