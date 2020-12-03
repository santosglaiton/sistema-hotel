package santosglaiton.project.hotel.Hotel.service;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santosglaiton.project.hotel.Hotel.exceptions.QuartoNotFoundException;
import santosglaiton.project.hotel.Hotel.model.Hospede;
import santosglaiton.project.hotel.Hotel.model.Quarto;
import santosglaiton.project.hotel.Hotel.repositories.QuartoRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    public Quarto find(Integer id) throws ObjectNotFoundException {
        Optional<Quarto> obj = quartoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id:" + id + ", Tipo: " + Quarto.class.getName()));
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

    public Quarto fazCheckIn(Integer quartoId){
        Optional<Quarto> quartoOptional = quartoRepository.findById(quartoId);
        if (quartoOptional.isPresent()){
            Quarto quarto = quartoOptional.get();
            quarto.setDataCheckIn(new Date());
            quarto.setQuartoOcupado(Boolean.TRUE);
            return quartoRepository.save(quarto);
        } else {
            throw new QuartoNotFoundException();
        }
    }

    public Quarto fazCheckOut(Integer quartoId){
        Optional<Quarto> quartoOptional = quartoRepository.findById(quartoId);
        if (quartoOptional.isPresent()){
            Quarto quarto = quartoOptional.get();
            quarto.setDataCheckOut(new Date());
            quarto.setQuartoLimpo(Boolean.FALSE);
            return quartoRepository.save(quarto);
        } else {
            throw new QuartoNotFoundException();
        }
    }


    public List<Quarto> getListaQuartosDisponiveis(){
        return quartoRepository.findByQuartoOcupadoFalseAndQuartoLimpoTrue();
    }

//    public Double calculaPrecoAPagar(Integer idQuarto){
//        Optional<Quarto> quartoOptional = quartoRepository.findById(idQuarto);
//        if (quartoOptional.isPresent()){
//            SimpleDateFormat sdf = new SimpleDateFormat();
//            Quarto quarto = quartoOptional.get();
//            Double precoQuarto = quarto.getPrecoQuarto();
//            Date checkin = quarto.getDataCheckIn();
//            Date checkout = quarto.getDataCheckOut();
//            checkin.compareTo(checkout);
//            checkin.
//        }
//        return resultado;
//    }resultado

}
