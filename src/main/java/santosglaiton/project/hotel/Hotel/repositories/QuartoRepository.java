package santosglaiton.project.hotel.Hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import santosglaiton.project.hotel.Hotel.model.Quarto;

import java.util.List;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Integer> {

    public List<Quarto> findByQuartoOcupadoFalseAndQuartoLimpoFalse();
    public List<Quarto> findByQuartoOcupadoFalseAndQuartoLimpoTrue();
}
