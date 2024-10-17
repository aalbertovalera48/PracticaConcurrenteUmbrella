import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.stereotype.Service;

@Service
public class FirebaseService {

    private final DatabaseReference dbRef;

    public FirebaseService() {
        this.dbRef = FirebaseDatabase.getInstance().getReference("biologicalData");
    }

    public void saveBiologicalData(BiologicalData data) {
        dbRef.child(data.getId()).setValueAsync(data);
    }
}
