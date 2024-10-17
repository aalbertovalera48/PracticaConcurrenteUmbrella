package HilosProcesos;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public void executeAsyncTask() {
        // Lógica de la tarea asincrónica
        System.out.println("Tarea asincrónica ejecutada en: " + Thread.currentThread().getName());
    }
}