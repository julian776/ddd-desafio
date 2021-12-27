package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.vuelos.domain.commands.AgregarTareaCommand;
import com.sofka.vuelos.domain.serviciopremium.ServicioPremium;

public class AgregarTareaUseCase extends UseCase<RequestCommand<AgregarTareaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarTareaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var servicio = ServicioPremium.from(command.getEntityId(), retrieveEvents());
        servicio.agregarTarea(command.getTarea());

        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
