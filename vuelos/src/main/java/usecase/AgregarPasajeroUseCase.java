package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.vuelos.domain.commands.AgregarPasajeroCommand;
import com.sofka.vuelos.domain.vuelo.Vuelo;

public class AgregarPasajeroUseCase extends UseCase<RequestCommand<AgregarPasajeroCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPasajeroCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var vuelo = Vuelo.from(command.getEntityId(), retrieveEvents());
        vuelo.agregarPasajero(command.getPasajero());

        emit().onResponse(new ResponseEvents(vuelo.getUncommittedChanges()));
    }
}
