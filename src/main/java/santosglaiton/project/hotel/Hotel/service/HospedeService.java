package santosglaiton.project.hotel.Hotel.service;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import santosglaiton.project.hotel.Hotel.model.Hospede;
import santosglaiton.project.hotel.Hotel.repositories.HospedeRepository;

import java.util.Optional;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository hospedeRepository;

    public Hospede find(Integer id) throws ObjectNotFoundException {
        Optional<Hospede> obj = hospedeRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id:" + id + ", Tipo: " + Hospede.class.getName()));
    }

    @Transactional
    public Hospede save(Hospede obj){
        if (obj.getNomeHospede() == null){
            throw new NullPointerException();
        }
        return hospedeRepository.save(obj);
    }

}
