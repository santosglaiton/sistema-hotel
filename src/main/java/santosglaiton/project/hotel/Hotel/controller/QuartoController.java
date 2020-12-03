package santosglaiton.project.hotel.Hotel.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import santosglaiton.project.hotel.Hotel.model.Quarto;
import santosglaiton.project.hotel.Hotel.service.QuartoService;

import java.util.List;

@RequestMapping("/quartos")
@RestController
public class QuartoController {

    @Autowired
    QuartoService quartoService;

    @GetMapping
    public ResponseEntity<List<Quarto>> findAll(){
       List<Quarto> obj = quartoService.getListaQuartosDisponiveis();
       return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/checkin")
    public ResponseEntity<Quarto> checkin(@PathVariable Integer id) throws ObjectNotFoundException {

        Quarto obj = quartoService.fazCheckIn(1);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
