package scjp.com.java.chapter9;

public class LockImpl
{
    private boolean isLocked = false;
    private Thread lockedBy = null;
    int lockedCount = 0;
    
    public synchronized void lock() throws InterruptedException 
    {
        Thread callingThread = Thread.currentThread();

        while(isLocked && lockedBy != callingThread )
            wait();
        
        lockedCount++;
        isLocked = true;
        lockedBy = callingThread;
    }
    
    public synchronized void unlock()
    {
        if(Thread.currentThread() == this.lockedBy )
            this.lockedCount--;
        
        if(this.lockedCount == 0)
        {
            this.isLocked = false;
            notify();
        }
    }
    
    

}
