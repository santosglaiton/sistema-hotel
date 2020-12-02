package santosglaiton.project.hotel.Hotel.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Hospede implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHospede;
    @Size(min = 1, max = 150)
    private String nomeHospede;
    @Size(min = 11, max = 11)
    private String cpf;
    @Size(min = 8, max = 8)
    private String cep;
    private String telefone;

    public Hospede() {
    }

    public Hospede(@Size(min = 8, max = 150) String nomeHospede, @Size(min = 11, max = 11) String cpf,@Size(min = 8, max = 8) String cep, String telefone) {
        this.nomeHospede = nomeHospede;
        this.cpf = cpf;
        this.cep = cep;
        this.telefone = telefone;
    }

    public Integer getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(Integer idHospede) {
        this.idHospede = idHospede;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospede hospede = (Hospede) o;
        return idHospede.equals(hospede.idHospede);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHospede);
    }

    @Override
    public String toString() {
        return "Hospede{" +
                "idHospede=" + idHospede +
                ", nomeHospede='" + nomeHospede + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}

