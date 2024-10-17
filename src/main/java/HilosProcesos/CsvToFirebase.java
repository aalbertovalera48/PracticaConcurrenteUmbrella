package HilosProcesos;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvToFirebase {
    public static void main(String[] args) {
        try {
            FileInputStream serviceAccount = new FileInputStream("src/main/resources/concurrente-umbrella-firebase-adminsdk-wub2g-ffa07f0960.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://concurrente-umbrella-default-rtdb.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("biologicaldata");

            // Leer el archivo CSV
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/smoking_cleaned.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, Object> data = new HashMap<>();
                data.put("id", values[0]);
                data.put("age", values[2]);
                data.put("gender", values[1]);
                data.put("heightCm", values[3]);
                data.put("weightKg", values[4]);
                data.put("waistCm", values[5]);
                data.put("eyesightLeft", values[6]);
                data.put("eyesightRight", values[7]);
                data.put("hearingLeft", values[8]);
                data.put("hearingRight", values[9]);
                data.put("systolic", values[10]);
                data.put("relaxation", values[11]);
                data.put("fastingBloodSugar", values[12]);
                data.put("cholesterol", values[13]);
                data.put("triglyceride", values[14]);
                data.put("hdl", values[15]);
                data.put("ldl", values[16]);
                data.put("hemoglobin", values[17]);
                data.put("urineProtein", values[18]);
                data.put("serumCreatinine", values[19]);
                data.put("ast", values[20]);
                data.put("alt", values[21]);
                data.put("gtp", values[22]);
                data.put("oralHealth", values[23]);
                data.put("dentalCaries", values[24]);
                data.put("tartar", values[25]);
                data.put("smoking", values[26]);

                // Sube los datos a Firebase
                ref.push().setValueAsync(data);
                System.out.println("Subiendo datos a Firebase...");
            }
            br.close();
            System.out.println("Datos subidos a Firebase");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}