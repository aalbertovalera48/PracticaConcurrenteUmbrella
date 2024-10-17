package HilosProcesos;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DataProcessingService {

    private final BiologicalDataFlow biologicalDataFlow;


    public DataProcessingService(BiologicalDataFlow biologicalDataFlow) {
        this.biologicalDataFlow = biologicalDataFlow;

    }

    @Async("taskExecutor")
    public void processBiologicalData() {
        biologicalDataFlow.processData();
    }
}
