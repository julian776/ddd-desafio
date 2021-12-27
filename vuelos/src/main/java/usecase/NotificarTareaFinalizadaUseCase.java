package usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.vuelos.domain.events.TareaFinalizada;

import java.util.List;

public class NotificarTareaFinalizadaUseCase extends UseCase<TriggeredEvent<TareaFinalizada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<TareaFinalizada> triggeredEvent) {
        //Se le notificaara al cliente que la tarea fue realizada via email
        var event = triggeredEvent.getDomainEvent();
        var service = getService(EnviarEmailService.class).orElseThrow();
        var response = service.send(event.getTareaId(),
                "aerolinea@sofka.support.com",
                "Apreciado cliente, nos complace informarle que la tarea se ha completado exitosamente");
        if(!response){
            throw new BusinessException(event.aggregateRootId(), "La notificacion no se pudo enviar");
        }

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
