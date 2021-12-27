package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.vuelos.domain.commands.CrearServicioPremiumCommand;
import com.sofka.vuelos.domain.serviciopremium.ServicioPremium;

public class CrearServicioUseCase extends UseCase<RequestCommand<CrearServicioPremiumCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearServicioPremiumCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var servicio = new ServicioPremium(command.getEntityId(), command.getVehiculosCliente(), command.getBeneficiarios(), command.getListadoTareas());
        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));
    }
}
