package scjp.com.java.languageFundamentals.chapter7;

import java.util.Set;
import java.util.TreeSet;

public class ComparableExMain
{
    public static void main( String[] args )
    {
        Set<Value> values = new TreeSet<Value>();
        values.add(new Value(4));
        values.add(new Value(3));
        
        for(Value value : values)
        System.out.println(value.value);
        
    }
}

class Value implements Comparable< Value >
{
    public Integer value;
    
    public Value(int value)
    {
        this.value = value;
    }
    
    @Override
    public int compareTo( Value o )
    {
        if(this.value > o.value)
            return 1;
        else if(this.value < o.value)
            return -1;
        else
            return 0;
    }
    
}
