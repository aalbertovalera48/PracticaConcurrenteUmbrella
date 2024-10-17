package HilosProcesos;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FirebaseService {

    @Autowired
    private FirebaseDatabase firebaseDatabase;

    public void saveBiologicalData(BiologicalData data) {
        DatabaseReference ref = firebaseDatabase.getReference("biologicaldata");
        ref.push().setValue(data, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    System.err.println("Data could not be saved " + databaseError.getMessage());
                } else {
                    System.out.println("Data saved successfully.");
                }
            }
        });
    }
    public List<BiologicalData> getData() {
        List<BiologicalData> dataList = new ArrayList<>();
        DatabaseReference ref = firebaseDatabase.getReference("biologicaldata");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    BiologicalData data = snapshot.getValue(BiologicalData.class);
                    dataList.add(data);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.err.println("Error fetching data: " + databaseError.getMessage());
            }
        });

        return dataList;
    }
}