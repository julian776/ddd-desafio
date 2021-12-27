package usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.vuelos.domain.events.VueloCambiado;

import java.util.List;

public class NotificarPasajeroCambioVueloUseCase extends UseCase<TriggeredEvent<VueloCambiado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<VueloCambiado> triggeredEvent) {
        var event = triggeredEvent.getDomainEvent();
        var service = getService(EnviarCambioVueloService.class).orElseThrow();
        var response = service.sendCambioVuelo(event.getVueloId(),
                "sofka-ventas@sofka.com",
                "Apreciado pasajero le notificamos su cambio de vuelo, su nuevo vuelo lo puede encontrar con" + event.getVueloId());
        if(!response){
            throw new BusinessException(event.getVueloId().value(), "No se pudo hacer la notificacion del cambio de vuelo");
        }

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
