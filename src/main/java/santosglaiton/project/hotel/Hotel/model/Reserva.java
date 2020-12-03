package santosglaiton.project.hotel.Hotel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long diasUsados;
    private Long precoFinal;
    private Hospede hospede;
    private Quarto quarto;

    public Reserva() {
    }

    public Reserva(Integer id, Long diasUsados, Long precoFinal, Hospede hospede, Quarto quarto) {
        this.id = id;
        this.diasUsados = diasUsados;
        this.precoFinal = precoFinal;
        this.hospede = hospede;
        this.quarto = quarto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return id.equals(reserva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getDiasUsados() {
        return diasUsados;
    }

    public void setDiasUsados(Long diasUsados) {
        this.diasUsados = diasUsados;
    }

    public Long getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(Long precoFinal) {
        this.precoFinal = precoFinal;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
}
