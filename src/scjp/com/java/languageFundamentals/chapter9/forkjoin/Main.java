package scjp.com.java.languageFundamentals.chapter9.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main
{
    public static void main( String[] args )
    {
        //Create ForkJoinPool using the default constructor.
        ForkJoinPool pool = new ForkJoinPool();
        //Create three FolderProcessor tasks. Initialize each one with a different folder path.
        FolderProcessor system = new FolderProcessor( "C:\\Windows", "log" );
        FolderProcessor apps = new FolderProcessor( "C:\\Program Files", "log" );
        FolderProcessor documents = new FolderProcessor( "C:\\Documents And Settings", "log" );
        //Execute the three tasks in the pool using the execute() method.
        pool.execute( system );
        pool.execute( apps );
        pool.execute( documents );
        //Write to the console information about the status of the pool every second
        //until the three tasks have finished their execution.
        do
        {
            System.out.printf( "******************************************\n" );
            System.out.printf( "Main: Parallelism: %d\n", pool.getParallelism() );
            System.out.printf( "Main: Active Threads: %d\n", pool.getActiveThreadCount() );
            System.out.printf( "Main: Task Count: %d\n", pool.getQueuedTaskCount() );
            System.out.printf( "Main: Steal Count: %d\n", pool.getStealCount() );
            System.out.printf( "******************************************\n" );
            try
            {
                TimeUnit.SECONDS.sleep( 1 );
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
        }
        while ( ( !system.isDone() ) || ( !apps.isDone() ) || ( !documents.isDone() ) );
        //Shut down ForkJoinPool using the shutdown() method.
        pool.shutdown();
        //Write the number of results generated by each task to the console.
        List< String > results;
        results = system.join();
        System.out.printf( "System: %d files found.\n", results.size() );
        results = apps.join();
        System.out.printf( "Apps: %d files found.\n", results.size() );
        results = documents.join();
        System.out.printf( "Documents: %d files found.\n", results.size() );
    }
}



/*
 * How it works?

In the FolderProcessor class, Each task processes the content of a folder. As you know, this content has the following two kinds of elements:

    Files
    Other folders

If the task finds a folder, it creates another Task object to process that folder and sends it to the pool using the fork() method. This method sends the task to the pool that will execute it if it has a free worker-thread or it can create a new one. The method returns immediately, so the task can continue processing the content of the folder. For every file, a task compares its extension with the one it�s looking for and, if they are equal, adds the name of the file to the list of results.

Once the task has processed all the content of the assigned folder, it waits for the finalization of all the tasks it sent to the pool using the join() method. This method called in a task waits for the finalization of its execution and returns the value returned by the compute() method. The task groups the results of all the tasks it sent with its own results and returns that list as a return value of the compute() method.
Difference between Fork/Join Framework And ExecutorService

The main difference between the Fork/Join and the Executor frameworks is the work-stealing algorithm. Unlike the Executor framework, when a task is waiting for the finalization of the sub-tasks it has created using the join operation, the thread that is executing that task (called worker thread ) looks for other tasks that have not been executed yet and begins its execution. By this way, the threads take full advantage of their running time, thereby improving the performance of the application.



Conclusion

Designing good multi-threaded algorithms is hard, and fork/join doesn�t work in every circumstance. It�s very useful within its own domain of applicability, but in the end, you have to decide whether your problem fits within the framework, and if not, you must be prepared to develop your own solution, building on the superb tools provided by java.util.concurrent package.
*
*
*/

