import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    private final DataProcessingService dataProcessingService;
    private final LoggingService loggingService;

    public DataController(DataProcessingService dataProcessingService, LoggingService loggingService) {
        this.dataProcessingService = dataProcessingService;
        this.loggingService = loggingService;
    }

    @GetMapping("/process-data")
    public String processData() {
        loggingService.logInfo("Iniciando procesamiento de datos...");
        dataProcessingService.processBiologicalData();
        loggingService.logInfo("Procesamiento de datos iniciado.");
        return "Procesamiento de datos en progreso...";
    }
}
