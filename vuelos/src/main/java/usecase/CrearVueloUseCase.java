package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.vuelos.domain.commands.CrearVueloCommand;
import com.sofka.vuelos.domain.vuelo.Vuelo;

public class CrearVueloUseCase extends UseCase<RequestCommand<CrearVueloCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearVueloCommand> requestCommand) {
        var command  = requestCommand.getCommand();
        var vuelo = new Vuelo(command.getEntityId(), command.getRuta(), command.getListaPasajeros(), command.getBodega(), command.getAvion());
        emit().onResponse(new ResponseEvents(vuelo.getUncommittedChanges()));
    }
}
