package santosglaiton.project.hotel.Hotel.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import santosglaiton.project.hotel.Hotel.model.Hospede;
import santosglaiton.project.hotel.Hotel.repositories.HospedeRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class HospedeServiceTest {

    @Mock
    private HospedeRepository hospedeRepository;
    @InjectMocks
    private HospedeService hospedeService;

    @Test
    void deveSalvarNovoHospede(){
        Hospede hospede = new Hospede(null, "Joaõ", "12345678901", "joao@gmail.com");
        Mockito.when(hospedeRepository.save(hospede)).thenReturn(hospede);

        Hospede atual = hospedeService.save(hospede);

        assertEquals(hospede, atual);
        Mockito.verify(hospedeRepository, Mockito.times(1)).save(hospede);
    }

    @Test
    void deveFalharAoSalvarNovoHospede(){

        Hospede esperado = new Hospede(null, null, "12345678901", "joão@gmail.com");
        Assertions.assertThrows(NullPointerException.class, () -> {
            hospedeService.save(esperado);
        });
        Mockito.verifyNoInteractions(hospedeRepository);
    }

}
