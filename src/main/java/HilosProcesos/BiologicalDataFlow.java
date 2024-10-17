import org.springframework.stereotype.Service;

@Service
public class BiologicalDataFlow implements DataFlow {
    @Override
    public void processData() {
        System.out.println("Procesando datos bioquímicos...");
        // Lógica específica para datos bioquímicos
    }
}