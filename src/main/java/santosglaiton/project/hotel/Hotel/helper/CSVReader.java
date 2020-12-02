package santosglaiton.project.hotel.Hotel.helper;

import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;
import santosglaiton.project.hotel.Hotel.model.Hospede;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    public static String TYPE = "text/csv";
    static String[] HEADER = {"Nome", "CPF", "CEP", "tELEFONE"};

    public static boolean temFormatoCsv(MultipartFile file){
        if (!TYPE.equals(file.getContentType())){
            return true;
        }

        return  false;
    }

    public static List<Hospede> csvHospede(InputStream obj) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(obj, "UTF-8" ));
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());){
            List<Hospede> hospedes = new ArrayList<Hospede>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Hospede hospede = new Hospede(
                        csvRecord.get("Nome"),
                        csvRecord.get("CPF"),
                        csvRecord.get("CEP"),
                        csvRecord.get("Telefone")
                );
                hospedes.add(hospede);
            }
            return hospedes;
        }catch (IOException e){
            throw  new RuntimeException("Falha no arquivo CSV: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream hospedeToCsv(List<Hospede> hospedeList) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Hospede hospede : hospedeList) {
                List<String> data = Arrays.asList(
                        String.valueOf(hospede.getNomeHospede()),
                        hospede.getCpf(),
                        hospede.getCep(),
                        hospede.getTelefone()
                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}
