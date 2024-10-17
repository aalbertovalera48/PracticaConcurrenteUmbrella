package HilosProcesos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;


/*
// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyDitFh8UH-waHdOs_nLWneSXfs_ORmpTVM",
  authDomain: "concurrente-umbrella.firebaseapp.com",
  databaseURL: "https://concurrente-umbrella-default-rtdb.firebaseio.com",
  projectId: "concurrente-umbrella",
  storageBucket: "concurrente-umbrella.appspot.com",
  messagingSenderId: "141803274332",
  appId: "1:141803274332:web:7bf7630cbfff05294c2699",
  measurementId: "G-Z6KKZ9BQQ1"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);
 */


@RestController
public class DataController {

    private final CsvService csvService;
    private final FirebaseService firebaseService;

    public DataController(CsvService csvService, FirebaseService firebaseService) {
        this.csvService = csvService;
        this.firebaseService = firebaseService;
    }

    @GetMapping("/upload-csv")
    public String uploadCsvToFirebase(@RequestParam String filePath) {
        try {
            List<BiologicalData> dataList = csvService.parseCsv(filePath);
            dataList.forEach(firebaseService::saveBiologicalData);
            return "Datos cargados en Firebase con éxito.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al cargar el archivo CSV.";
        }
    }
}
