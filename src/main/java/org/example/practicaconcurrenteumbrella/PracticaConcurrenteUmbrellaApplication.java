package org.example.practicaconcurrenteumbrella;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class PracticaConcurrenteUmbrellaApplication {

    public static void main(String[] args) {
        initializeFirebase();
        SpringApplication.run(PracticaConcurrenteUmbrellaApplication.class, args);
    }

    private static void initializeFirebase() {
        if (FirebaseApp.getApps().isEmpty()) {
            try {
                FileInputStream serviceAccount = new FileInputStream("src/main/resources/concurrente-umbrella-firebase-adminsdk-wub2g-ffa07f0960.json");

                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .setDatabaseUrl("https://concurrente-umbrella-default-rtdb.firebaseio.com")
                        .build();

                FirebaseApp.initializeApp(options);
                System.out.println("Firebase initialized successfully.");
            } catch (IOException e) {
                System.err.println("Failed to initialize Firebase: " + e.getMessage());
            }
        } else {
            System.out.println("Firebase is already initialized.");
        }
    }
}
