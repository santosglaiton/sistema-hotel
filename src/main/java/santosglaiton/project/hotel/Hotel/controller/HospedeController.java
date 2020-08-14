package santosglaiton.project.hotel.Hotel.controller;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import santosglaiton.project.hotel.Hotel.model.Hospede;
import santosglaiton.project.hotel.Hotel.service.HospedeService;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {

    @Autowired
    private HospedeService hospedeService;

    @GetMapping("/id") //procura hospede por id
    public ResponseEntity<Hospede> find(@PathVariable Integer id) throws ObjectNotFoundException {
        Hospede obj = hospedeService.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
