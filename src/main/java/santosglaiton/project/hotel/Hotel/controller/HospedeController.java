package santosglaiton.project.hotel.Hotel.controller;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import santosglaiton.project.hotel.Hotel.model.Hospede;
import santosglaiton.project.hotel.Hotel.service.HospedeService;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Hospede>> findAll () throws ObjectNotFoundException {
        List<Hospede> hospedes = this.hospedeService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(hospedes);
    }

}
