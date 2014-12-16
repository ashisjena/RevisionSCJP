package scjp.com.java.dynamicProgramming;

public class MusicPlaylistClass
{
    public static void main( String[] args )
    {
        for(int index = 0; index < 5 ; index++)
        {
            getRandomNumber( 10 );
        }
        
    }
    
    public static int getRandomNumber(int maxLimit)
    {
        double random = Math.random();
        System.out.println(random);
        return 0;
    }
    
    
}
