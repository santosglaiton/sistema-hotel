package santosglaiton.project.hotel.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import santosglaiton.project.hotel.Hotel.model.Quarto;
import santosglaiton.project.hotel.Hotel.repositories.QuartoRepository;
import santosglaiton.project.hotel.Hotel.service.QuartoService;

import java.text.SimpleDateFormat;

@EnableJpaRepositories
@SpringBootApplication
public class HotelApplication implements CommandLineRunner {

	@Autowired
	QuartoRepository quartoRepository;

	@Autowired
	QuartoService quartoService;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Quarto quarto = new Quarto(1, Boolean.FALSE, Boolean.TRUE, 120.0, "Normal", null, null);
		quartoRepository.save(quarto);

		Quarto quarto1 = new Quarto(2, Boolean.FALSE, Boolean.TRUE, 200.0, "Suite", null, null);
		quartoRepository.save(quarto1);

		quartoService.fazCheckIn(1);
		quartoService.fazCheckOut(1);
	}
}
