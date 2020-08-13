package santosglaiton.project.hotel.Hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import santosglaiton.project.hotel.Hotel.model.Hospede;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Integer> {
}
