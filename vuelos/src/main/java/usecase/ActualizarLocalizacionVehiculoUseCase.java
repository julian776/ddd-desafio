package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.vuelos.domain.commands.ActualizarLocalizacionVehiculoCommand;
import com.sofka.vuelos.domain.serviciopremium.ServicioPremium;

public class ActualizarLocalizacionVehiculoUseCase extends UseCase<RequestCommand<ActualizarLocalizacionVehiculoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarLocalizacionVehiculoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var servicio = ServicioPremium.from(command.getEntityId(), retrieveEvents());
        servicio.actualizarLocalizacionVehiculo(command.getVehiculoId(), command.getLocalizacion());

        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
