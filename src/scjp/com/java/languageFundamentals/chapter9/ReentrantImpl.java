package scjp.com.java.languageFundamentals.chapter9;

public class ReentrantImpl
{
    LockImpl lock = new LockImpl();
    
    public void outer() throws InterruptedException
    {
        lock.lock();
        
        inner();
        
        lock.unlock();
    }

    public void inner() throws InterruptedException
    {
        lock.lock();
        
        // do Some work;
        
        lock.unlock();
    }
}