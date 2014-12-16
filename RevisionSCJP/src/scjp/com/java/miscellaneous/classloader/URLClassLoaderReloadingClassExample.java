package scjp.com.java.miscellaneous.classloader;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class URLClassLoaderReloadingClassExample
{
    public static void main( String[] args ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException, IOException
    {
        URL url = new URL( "jar:file:E:/Program Files/workspace/RevisionSCJP/bin/foo.jar!/" ); 
        String className = null;
        
        // These all are just to get the class name.
        /*JarFile jarFile = new JarFile( "E:/Program Files/workspace/RevisionSCJP/bin/foo.jar" );
        Enumeration< JarEntry > e = jarFile.entries();
        while ( e.hasMoreElements() )
        {
            JarEntry je = (JarEntry)e.nextElement();
            if ( je.isDirectory() || !je.getName().endsWith( ".class" ) )
                continue;
            
            className = je.getName().substring( 0, je.getName().length() - 6 );
            System.out.println(className);
            className = className.replace( '/', '.' );
            System.out.println(className);
        }*/
        //or
        className = "scjp.com.java.miscellaneous.Foo";
        
        URLClassLoader loader = new URLClassLoader( new URL[] {url} );
        Class c1 = loader.loadClass( className );
        Runnable foo = (Runnable) c1.newInstance();
        Thread t1 = new Thread(foo);
        t1.start();
        t1 = null;
        c1 = null;
        foo = null;
        
        int count = 0;
        loader.close();  // No difference has been seen while this program execution, or may be this unlocks the jar file so that we can delete it.
        // yes during manual deletion it says that program is using and doesn't allow it, but after closing class loader it allows.
        
        System.out.println("Loader is closed");
        System.gc();
        System.gc();
        Thread.sleep( 20000 );
        // now change the foo class static variable quickly and update the jar 
        // and delete the Foo.class from bin, otherwise it will pick the class file instead of getting it from jar
        
        System.out.println("Sleep time out");
        loader = new URLClassLoader( new URL[] {url} );
        Class c2 = loader.loadClass( className );
        foo = (Runnable) c2.newInstance();
        t1 = new Thread(foo);
        t1.start();
        
        // here both the classloader will load the Foo class twice. one is before changing and after changing
        // As the class loading is associated with classloader, and here we are creating a new instance of the classloader so two times the class Foo will be loaded.
        // calling System.gc() may be unload the classloader and prev class both. unless and until someone refers it or current object execution is happening
        
    }
}