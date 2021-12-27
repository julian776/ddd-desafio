package usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import com.sofka.vuelos.domain.events.TareaFinalizada;
import com.sofka.vuelos.domain.serviciopremium.TareaId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class NotificarTareaFinalizadaUseCaseTest {

    @Test
    void testFinalizacionTarea(){
        var event = new TareaFinalizada(new TareaId("aaa"));
        var usecase = new NotificarTareaFinalizadaUseCase();
    }
}