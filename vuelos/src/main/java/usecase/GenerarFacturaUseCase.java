package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.vuelos.domain.commands.GenerarFacturaCommand;
import com.sofka.vuelos.domain.venta.Venta;

public class GenerarFacturaUseCase extends UseCase<RequestCommand<GenerarFacturaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<GenerarFacturaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var venta = new Venta(command.getEntityId(), command.getFactura(), command.getVueloId(), command.getTiquete(), command.getMercancia());
        venta.generarFactura();
        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
