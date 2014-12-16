package scjp.com.java.miscellaneous.classloader;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassLoaderForExternalJar
{
    public static void main( String args[] ) throws IOException, ClassNotFoundException
    {
        Map< String, Class > jarMap = loadJar( "E:/Essentials/Softwares/Javaaaaaaaaaaaa/jars/joda-time-2.4/joda-time-2.4.jar" );
        System.out.println( jarMap.size() );
        for ( Class clazz : jarMap.values() )
            System.out.println( clazz.getName() );
    }

    private final static Map< String, Map< String, Class >> classMapToJar = new HashMap< String, Map< String, Class >>();

    public static Map< String, Class > loadJar( String pathToJar ) throws IOException, ClassNotFoundException
    {
        Map< String, Class > classMap;
        synchronized (pathToJar)
        {
            classMap = classMapToJar.get( pathToJar );
            if ( classMap == null )
                classMap = new HashMap< String, Class >();
            else
                return Collections.unmodifiableMap( classMap );

            JarFile jarFile = new JarFile( pathToJar );
            Enumeration< JarEntry > e = jarFile.entries();

//            URL[] urls = { new URL( "jar:file:" + pathToJar + "!/" ) };
//            URLClassLoader cl = URLClassLoader.newInstance( urls );

            while ( e.hasMoreElements() )
            {
                JarEntry je = (JarEntry)e.nextElement();
                if ( je.isDirectory() || !je.getName().endsWith( ".class" ) )
                    continue;

                String className = je.getName().substring( 0, je.getName().length() - 6 );
                className = className.replace( '/', '.' );
                //Class c = cl.loadClass( className );
                ClassLoader cl = ClassLoaderForExternalJar.class.getClassLoader();
                Class c = cl.loadClass( className);
                //Class c = Class.forName( className );
                classMap.put( c.getName(), c );
            }
            classMapToJar.put( pathToJar, classMap );
        }
        return Collections.unmodifiableMap( classMap );
    }
}