package santosglaiton.project.hotel.Hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import santosglaiton.project.hotel.Hotel.model.Quarto;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Integer> {
}
