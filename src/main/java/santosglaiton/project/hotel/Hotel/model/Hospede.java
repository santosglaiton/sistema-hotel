package santosglaiton.project.hotel.Hotel.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class Hospede implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHospede;
    private String nomeHospede;
    private String cpf;
    private String email;

    public Hospede() {
    }

    public Hospede(Integer idHospede, String nomeHospede, String cpf, String email) {
        this.idHospede = idHospede;
        this.nomeHospede = nomeHospede;
        this.cpf = cpf;
        this.email = email;
    }

    public Integer getIdHospede() {
        return idHospede;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
