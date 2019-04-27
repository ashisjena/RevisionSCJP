package scjp.com.java.chapter6;

public class RegularExpressionExample
{
    public static void main( String[] args )
    {
        String mailId = "ashisjena_talk2u@gmail.com";
        String regularExpression ="[a-z][a-z0-9._]*{5,}@[a-z0-9]+.[a-z]{2,3}"; 
        System.out.println(mailId.matches( regularExpression ));
        
        String test = "adsfds\\"; //Here it is a single \
        String testPattern = "\\w+\\\\";  
        System.out.println(test.matches( testPattern ));
        /*
         * Any punctuation can be represented as below
         * Ex: 
         * \\\\ for \ , actually \\ is for \ but in java for escape character we need to write \\ for one \ and \\ for another \
         * \\. or . for .
         * \\@ or @ for @
         * \\w for [a-zA-Z_0-9]
         * \\w+ for [a-zA-Z_0-9]+
         * \\d for [0-9]
         * ^ Not
         * X?   X, once or not at all
         * X*  X, zero or more times
         * X+  X, one or more times
         * X{n}    X, exactly n times
         * X{n,}   X, at least n times
         * X{n,m}  X, at least n but not more than m times
         */
        
        
        String movieName = "12.Years.A.Slave.2013.1080p.BRRip.h264.AAC-RARBG.avi";
        String regExp = "[.][\\^avi]";//&&[^avi]&&[^mkv]&&[^flv]&&[^mp4]";
        System.out.println(movieName.replaceAll( regExp, " " ));
    }
}
