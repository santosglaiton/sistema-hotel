package santosglaiton.project.hotel.Hotel.model;

import com.sun.istack.NotNull;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Hospede implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHospede;
    private String nomeHospede;
    private String cpf;
    private Quarto quarto;
    private Date dataDeEntrada;
    private Date dataDeSaida;

}
