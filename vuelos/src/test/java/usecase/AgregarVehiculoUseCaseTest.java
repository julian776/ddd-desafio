package usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.domain.commands.AgregarVehiculoCommand;
import com.sofka.vuelos.domain.events.ServicioIniciado;
import com.sofka.vuelos.domain.events.VehiculoAgregado;
import com.sofka.vuelos.domain.serviciopremium.InformacionVehiculo;
import com.sofka.vuelos.domain.serviciopremium.ServicioPremiumId;
import com.sofka.vuelos.domain.serviciopremium.VehiculoCliente;
import com.sofka.vuelos.domain.serviciopremium.VehiculoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarVehiculoUseCaseTest {

    @Mock
    DomainEventRepository repository;


    @Test
    void agregarVehiculo(){
        //Arrange
        ServicioPremiumId entityId = new ServicioPremiumId("servicio");
        VehiculoId vehiculoId = new VehiculoId("vehiculo");
        var info = new InformacionVehiculo("avion", 454165L, 1L, "Ga");
        VehiculoCliente vehiculo = new VehiculoCliente(vehiculoId, "Italia", info);

        var command = new AgregarVehiculoCommand(entityId, vehiculo);
        var usecase = new AgregarVehiculoUseCase();

        //Act
        when(repository.getEventsBy(entityId.value())).thenReturn(events());
        usecase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("servicio")
                .syncExecutor(usecase, new RequestCommand<>(command)).orElseThrow();

        //Assert
        var event = (VehiculoAgregado) events.getDomainEvents().get(0);
        Assertions.assertEquals("servicio", event.aggregateRootId());
        Assertions.assertEquals("Italia", event.getVehiculo().getLocalizacion());
        Assertions.assertEquals(1L, event.getVehiculo().getInformacionVehiculo().identificador());
        Mockito.verify(repository).getEventsBy("servicio");
    }

    private List<DomainEvent> events() {
        return List.of(new ServicioIniciado(new Hashtable<>(), new ArrayList<>(), new Hashtable<>()));
    }
}