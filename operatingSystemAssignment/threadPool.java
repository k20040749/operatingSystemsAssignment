import java.util.ArrayList;

/**
 * Write a description of class threadPool here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class threadPool implements Runnable
{
    // instance variables - replace the example below with your own
    private int threadSize;
    private int numberRunning;
    private ArrayList<ImageProcessorST> runningTasks;
    private ArrayList<ImageProcessorST> waitingTasks;
    /**
     * Constructor for objects of class threadPool
     */
    public threadPool(int size)
    {
        threadSize = size;
        numberRunning = 0;
        runningTasks = new ArrayList<>();
        waitingTasks = new ArrayList<>();
    }

    public void start() {
        while (runningTasks.size() < threadSize) {
            if (waitingTasks.size() > 0){
                runningTasks.add(waitingTasks.remove(0));
            }
        }
    }
    
    public void run() {}
    
    public void submit(ImageProcessorST task) {
        waitingTasks.add(task);
    }
    
    public void join() {}
    
    public void quit() {}
}
    
