package usecase;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.vuelos.domain.events.VueloCambiado;
import com.sofka.vuelos.domain.vuelo.VueloId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotificarPasajeroCambioVueloTest {

    @Mock
    EnviarCambioVueloService service;

    @Test
    void testEnviarCambioDeVuelo(){
        var vueloId = new VueloId("aaa");
        var event = new VueloCambiado(vueloId);
        var usecase = new NotificarPasajeroCambioVueloUseCase();

        when(service.sendCambioVuelo(event.getVueloId(),
                "sofka-ventas@sofka.com",
                "Apreciado pasajero le notificamos su cambio de vuelo, su nuevo vuelo lo puede encontrar con" + event.getVueloId()))
                .thenReturn(true);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(service);
        usecase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance().syncExecutor(usecase, new TriggeredEvent<>(event)).orElseThrow();

        verify(service).sendCambioVuelo(new VueloId("aaa"),
                "sofka-ventas@sofka.com",
                "Apreciado pasajero le notificamos su cambio de vuelo, su nuevo vuelo lo puede encontrar con" + event.getVueloId());
    }
}