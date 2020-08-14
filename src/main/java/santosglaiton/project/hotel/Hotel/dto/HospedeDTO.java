package santosglaiton.project.hotel.Hotel.dto;

import java.io.Serializable;
import org.hibernate.validator.constraints.Length;
import santosglaiton.project.hotel.Hotel.model.Hospede;

import javax.validation.constraints.NotEmpty;

public class HospedeDTO implements Serializable {

    private Integer id;
    @NotEmpty(message = "Nome deve ser preenchido")
    @Length(min = 3, max = 120, message = "O tamanho deve ser entre 3 e 120 caracteres")
    private String nomeHospede;
    @NotEmpty(message = "O campo CPF deve ser preenchido")
    @Length(min = 11, max = 11, message = "O CPF deve conter 11 digitos")
    private String cpf;
    @NotEmpty(message = "O campo e-mail deve ser preenchido")
    @Length(min = 10, max = 100, message = "O tamanho do e-mail deve ser entre 10 e 100 caracteres")
    private String email;

    public HospedeDTO() {
    }

    public HospedeDTO(Hospede obj){
        id = obj.getIdHospede();
        nomeHospede = obj.getNomeHospede();
        cpf = obj.getCpf();
        email = obj.getEmail();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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
