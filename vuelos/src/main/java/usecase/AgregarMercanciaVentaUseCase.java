package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.vuelos.domain.commands.AgregarMercanciaVentaCommand;
import com.sofka.vuelos.domain.venta.Venta;

public class AgregarMercanciaVentaUseCase extends UseCase<RequestCommand<AgregarMercanciaVentaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMercanciaVentaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var venta = Venta.from(command.getEntityId(), retrieveEvents());
        venta.agregarMercanciaVenta(command.getPiezas());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
