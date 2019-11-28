package scjp.com.java.languageFundamentals.chapter7;

import java.util.HashMap;
import java.util.Map;

public class MapStringKeyComparision
{
    static Map< String, Integer > hashMap = new HashMap< String, Integer >();

    public static void main( String[] args )
    {
        hashMap.put( "Ravi", 1 );
        hashMap.put( "Rama", 2 );
        hashMap.put( "Sita", 3 );
        hashMap.put( "Rama", 4 );
        hashMap.put( "Gita", 5 );
        
        String name = "Rama";
        System.out.println(hashMap.get("Rama"));
    }
}
