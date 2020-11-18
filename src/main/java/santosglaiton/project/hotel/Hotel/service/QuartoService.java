package santosglaiton.project.hotel.Hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santosglaiton.project.hotel.Hotel.exceptions.QuartoNotFoundException;
import santosglaiton.project.hotel.Hotel.model.Quarto;
import santosglaiton.project.hotel.Hotel.repositories.QuartoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    public void salvar(Quarto quarto){
    }

    public QuartoService(QuartoRepository quartoRepository){
        this.quartoRepository = quartoRepository;
    }

    public List<Quarto> getListaDeQuartosParaLimpar(){
        return quartoRepository.findByQuartoOcupadoFalseAndQuartoLimpoFalse();
    }

    public Quarto atualizaQuartoParaLimpo(Integer quartoId){
        Optional<Quarto> quartoOptional = quartoRepository.findById(quartoId);
        if (quartoOptional.isPresent()) {
            Quarto quarto = quartoOptional.get();
            quarto.setQuartoLimpo(Boolean.TRUE);
            return quartoRepository.save(quarto);
        } else {
            throw new QuartoNotFoundException();
        }
    }

    public List<Quarto> getListaQuartosDisponiveis(){
        return quartoRepository.findByQuartoOcupadoFalseAndQuartoLimpoTrue();
    }

}
