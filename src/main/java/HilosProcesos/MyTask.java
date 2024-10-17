package HilosProcesos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTask implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(MyTask.class);

    @Override
    public void run() {
        logger.info("Thread {} started", Thread.currentThread().getName());
        // Simulate task execution
        try {
            Thread.sleep(1000); // Simulate some work with sleep
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Thread {} was interrupted", Thread.currentThread().getName());
        }
        logger.info("Thread {} finished", Thread.currentThread().getName());
    }
}