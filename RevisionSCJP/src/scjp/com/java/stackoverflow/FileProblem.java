package scjp.com.java.stackoverflow;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileProblem
{
    public static final String directoryPath = "F:/Songs";
    public static void main( String[] args )
    {
        File file = new File( directoryPath );
        if ( !file.isDirectory() )
            return;

        Map< String, List< File >> fileMap = new HashMap< String, List< File >>();
        for ( File txtFile : file.listFiles() )
        {
            if ( txtFile.isDirectory() )
                continue;
            List< File > fileList = fileMap.get( txtFile.getName().substring( 0, txtFile.getName().length() - 5 ) );
            if ( fileList == null )
                fileList = new ArrayList< File >();
            fileList.add( txtFile );
            
            System.out.println(txtFile.getAbsolutePath());
        }

        //Write logic to get the year as input
        String input = "1986";
        List< File > files = fileMap.get( input.substring( 0, input.length() - 1 ) );
    }
}
