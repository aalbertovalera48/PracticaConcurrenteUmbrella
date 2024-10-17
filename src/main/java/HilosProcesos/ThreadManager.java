package HilosProcesos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadManager {
    private static final Logger logger = LoggerFactory.getLogger(ThreadManager.class);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new MyTask(), "Thread-" + i);
            logger.info("Creating {}", thread.getName());
            thread.start();
        }
    }
}