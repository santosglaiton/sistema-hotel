package santosglaiton.project.hotel.Hotel.service;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santosglaiton.project.hotel.Hotel.model.Reserva;
import santosglaiton.project.hotel.Hotel.repositories.HospedeRepository;
import santosglaiton.project.hotel.Hotel.repositories.QuartoRepository;
import santosglaiton.project.hotel.Hotel.repositories.ReservaRepository;

import javax.transaction.Transactional;

@Service
public class ReservaService {

    @Autowired
    HospedeRepository hospedeRepository;

    @Autowired
    QuartoRepository quartoRepository;

    @Autowired
    HospedeService hospedeService;

    @Autowired
    QuartoService quartoService;

    @Autowired
    ReservaRepository repository;

    @Transactional
    public Reserva makeReservation(Reserva obj) throws ObjectNotFoundException {
        obj.setId(null);
        obj.setHospede(hospedeService.find(obj.getHospede().getIdHospede()));
        obj.setQuarto(quartoService.find(obj.getQuarto().getIdQuarto()));

        return repository.save(obj);
    }

}
