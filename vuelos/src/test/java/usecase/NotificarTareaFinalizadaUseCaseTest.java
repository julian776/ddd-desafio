package usecase;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.vuelos.domain.events.TareaFinalizada;
import com.sofka.vuelos.domain.serviciopremium.TareaId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotificarTareaFinalizadaUseCaseTest {

    @Mock
    EnviarEmailService service;

    @Test
    void testNotificacionTareaFinalizada(){
        var tareaId = new TareaId("aaa");
        var event = new TareaFinalizada(tareaId);
        var usecase = new NotificarTareaFinalizadaUseCase();

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(service);
        usecase.addServiceBuilder(builder);

        when(service.send(tareaId, "aerolinea@sofka.support.com", "Apreciado cliente, nos complace informarle que la tarea se ha completado exitosamente"))
                .thenReturn(true);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new TriggeredEvent<>(event))
                .orElseThrow();

        //assert
        verify(service).send(new TareaId("aaa"), "aerolinea@sofka.support.com", "Apreciado cliente, nos complace informarle que la tarea se ha completado exitosamente");
    }
}