package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.vuelos.domain.commands.CrearVentaCommand;
import com.sofka.vuelos.domain.venta.Venta;

public class CrearVentaUseCase extends UseCase<RequestCommand<CrearVentaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearVentaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var venta = new Venta(command.getEntityId(), command.getFactura(), command.getVueloId(), command.getTiquete(), command.getMercancia());
        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
