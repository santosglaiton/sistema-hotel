package santosglaiton.project.hotel.Hotel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Quarto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idQuarto;
    private Integer numeroQuarto;
    private Boolean quartoOcupado = false;
    private Boolean quartoLimpo = false;
    private Double precoQuarto;
    private String tipoQuarto;
    private Date dataCheckIn;
    private Date dataCheckOut;

    public Quarto() {
    }

    public Quarto(Integer numeroQuarto, Boolean quartoOcupado, Boolean quartoLimpo, Double precoQuarto, String tipoQuarto, Date dataCheckIn, Date dataCheckOut) {
        this.numeroQuarto = numeroQuarto;
        this.quartoOcupado = quartoOcupado;
        this.quartoLimpo = quartoLimpo;
        this.precoQuarto = precoQuarto;
        this.tipoQuarto = tipoQuarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
    }

    public Integer getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Integer idQuarto) {
        this.idQuarto = idQuarto;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Boolean getQuartoOcupado() {
        return quartoOcupado;
    }

    public void setQuartoOcupado(Boolean quartoOcupado) {
        this.quartoOcupado = quartoOcupado;
    }

    public Boolean getQuartoLimpo() {
        return quartoLimpo;
    }

    public void setQuartoLimpo(Boolean quartoLimpo) {
        this.quartoLimpo = quartoLimpo;
    }

    public Double getPrecoQuarto() {
        return precoQuarto;
    }

    public void setPrecoQuarto(Double precoQuarto) {
        this.precoQuarto = precoQuarto;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public Date getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(Date dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public Date getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(Date dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quarto quarto = (Quarto) o;
        return idQuarto.equals(quarto.idQuarto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuarto);
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "idQuarto=" + idQuarto +
                ", numeroQuarto=" + numeroQuarto +
                ", quartoOcupado=" + quartoOcupado +
                ", quartoLimpo=" + quartoLimpo +
                ", precoQuarto=" + precoQuarto +
                ", tipoQuarto='" + tipoQuarto + '\'' +
                ", dataCheckIn=" + dataCheckIn +
                ", dataCheckOut=" + dataCheckOut +
                '}';
    }
}
