package santosglaiton.project.hotel.Hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import santosglaiton.project.hotel.Hotel.helper.CSVReader;
import santosglaiton.project.hotel.Hotel.model.Hospede;
import santosglaiton.project.hotel.Hotel.repositories.HospedeRepository;

import java.io.IOException;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    HospedeRepository hospedeRepository;

    public void save (MultipartFile file){
        try {
            List<Hospede> hospedes = CSVReader.csvHospede(file.getInputStream());
            hospedeRepository.saveAll(hospedes);
        } catch (IOException e){
            throw new RuntimeException("Falha ao salvar arquivo CSV: " + e.getMessage());
        }
    }

    public List<Hospede> getAllHospedes(){
        return hospedeRepository.findAll();
    }

}
