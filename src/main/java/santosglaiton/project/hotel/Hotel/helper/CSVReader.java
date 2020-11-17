package santosglaiton.project.hotel.Hotel.helper;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;
import santosglaiton.project.hotel.Hotel.model.Hospede;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static String TYPE = "text/csv";
    static String[] HEADER = {"nome", "cpf", "telefone", "cep"};

    public static boolean temFormatoCsv(MultipartFile file){
        if (!TYPE.equals(file.getContentType())){
            return false;
        }

        return  true;
    }

    public static List<Hospede> csvHospede(InputStream obj) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(obj, "UTF-8" ));
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());){
            List<Hospede> hospedes = new ArrayList<Hospede>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Hospede hospede = new Hospede(
                        csvRecord.get("nome"),
                        csvRecord.get("cpf"),
                        csvRecord.get("telefone"),
                        csvRecord.get("cep")
                );
                hospedes.add(hospede);
            }
            return hospedes;
        }catch (IOException e){
            throw  new RuntimeException("Falha no arquivo CSV: " + e.getMessage());
        }
    }

}
