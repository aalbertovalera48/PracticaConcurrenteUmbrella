import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initializeFirebase() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/concurrente-umbrella-firebase-adminsdk-wub2g-ffa07f0960.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://console.firebase.google.com/u/0/project/concurrente-umbrella/database/concurrente-umbrella-default-rtdb/data/~2F?hl=es-419")
                .build();

        FirebaseApp.initializeApp(options);
    }
}
