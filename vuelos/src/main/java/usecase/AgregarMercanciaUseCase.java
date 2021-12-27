package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.vuelos.domain.commands.AgregarMercanciaCommand;
import com.sofka.vuelos.domain.vuelo.Vuelo;

public class AgregarMercanciaUseCase extends UseCase<RequestCommand<AgregarMercanciaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMercanciaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var vuelo = Vuelo.from(command.getEntityId(), retrieveEvents());
        vuelo.agregarMercancia(command.getPiezas());

        emit().onResponse(new ResponseEvents(vuelo.getUncommittedChanges()));
    }
}
