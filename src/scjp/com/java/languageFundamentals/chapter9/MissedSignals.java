package scjp.com.java.languageFundamentals.chapter9;

public class MissedSignals
{
    public static void main( String[] args )
    {
        MissedSignals missedSignals = new MissedSignals();
        MissedSignals.MyObject myObject = missedSignals.new MyObject();
        MissedSignals.MyThread myThread1 = missedSignals.new MyThread( myObject );
        myThread1.start();
        
        
        

    }

    class MyThread extends Thread
    {
        private MyObject myObject;

        MyThread( MyObject myObject )
        {
            this.myObject = myObject;
        }

        @Override
        public void run()
        {
            synchronized (myObject)
            {
                myObject.notifyAll();
            }

        }
    }

    class MyObject
    {

    }
}
