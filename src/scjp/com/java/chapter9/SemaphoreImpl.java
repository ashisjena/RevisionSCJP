package scjp.com.java.chapter9;

public class SemaphoreImpl {  // Semaphore objective is not to miss any signaling
    private int signals = 0;
    private int bound   = 0;
    private boolean isBounded = false;

    public SemaphoreImpl(){}
    
    public SemaphoreImpl(int upperBound){  // Semaphore is bounded  // Set the upperBound as '1' to use it as lock
      this.bound = upperBound;
      this.isBounded = true;
    }

    public synchronized void take() throws InterruptedException{    // Use take() instead of notify()
      while(this.isBounded && this.signals == bound) 
          wait();
      this.signals++;
      this.notify();
    }

    public synchronized void release() throws InterruptedException{    // Use release() instead of wait()
      while(this.signals == 0) 
          wait();
      this.signals--;
      this.notify();
    }
  }