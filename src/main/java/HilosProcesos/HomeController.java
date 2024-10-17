package HilosProcesos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private FirebaseService firebaseService;

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/")
    public String index(Model model) {
        List<BiologicalData> data = firebaseService.getData();
        model.addAttribute("biologicaldata", data);

        // Llamar al método asincrónico
        asyncService.executeAsyncTask();

        return "index";
    }
}