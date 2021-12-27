package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.vuelos.domain.commands.AgregarVehiculoCommand;
import com.sofka.vuelos.domain.serviciopremium.ServicioPremium;

public class AgregarVehiculoUseCase extends UseCase<RequestCommand<AgregarVehiculoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarVehiculoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var servicio = ServicioPremium.from(command.getEntityId(), retrieveEvents());
        servicio.agregarVehiculo(command.getVehiculo());

        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
