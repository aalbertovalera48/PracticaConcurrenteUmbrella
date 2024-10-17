package HilosProcesos;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class CsvService {

    public List<BiologicalData> parseCsv(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            CsvToBean<BiologicalData> csvToBean = new CsvToBeanBuilder<BiologicalData>(reader)
                    .withType(BiologicalData.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        }
    }
}
