package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.vuelos.domain.commands.darTareaTerminadaCommand;
import com.sofka.vuelos.domain.serviciopremium.ServicioPremium;

public class darTareaTerminadaUseCase extends UseCase<RequestCommand<darTareaTerminadaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<darTareaTerminadaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var servicio = ServicioPremium.from(command.getEntityId(), retrieveEvents());
        servicio.darTareaTerminada(command.getTareaId());

        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
