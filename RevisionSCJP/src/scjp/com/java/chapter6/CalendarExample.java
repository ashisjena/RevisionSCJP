package scjp.com.java.chapter6;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;

//import com.azure.sparkcommon.SparkDate;

public class CalendarExample
{
    public static void main( String[] args )
    {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        //cal.add( Calendar.DAY_OF_MONTH, 5 );
        cal.roll( Calendar.DAY_OF_MONTH, 1 );
        System.out.println( cal.getTime().toString() );
        Date currentDate = new Date();
        DateTime dateTime = new DateTime(); 
        DateTime pivotDttm = new DateTime();
        pivotDttm = pivotDttm.plusDays( 1 );
        //System.out.println(SparkDate.dayDiff( dateTime, pivotDttm ));
    }
}