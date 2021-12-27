package usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.domain.Sexo;
import com.sofka.vuelos.domain.commands.AgregarTareaCommand;
import com.sofka.vuelos.domain.events.ServicioIniciado;
import com.sofka.vuelos.domain.events.TareaAgregada;
import com.sofka.vuelos.domain.events.VentaEfectuada;
import com.sofka.vuelos.domain.serviciopremium.*;
import com.sofka.vuelos.domain.venta.*;
import com.sofka.vuelos.domain.vuelo.Identificacion;
import com.sofka.vuelos.domain.vuelo.Ruta;
import com.sofka.vuelos.domain.vuelo.VueloId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarTareaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarTareaTest(){
        //Arrange
        var entityId = new ServicioPremiumId("servicioTareaId");
        var info = new InformacionVehiculo("avion", 454165L, 1L, "Ga");
        var vehiculoCliente = new VehiculoCliente(new VehiculoId("vehiculo"), "Londres", info);
        var tarea = new Tarea(new TareaId("tarea")
                , "Londres", "Amsterdam", new TipoTarea("mover", "xx")
                , vehiculoCliente);
        var command = new AgregarTareaCommand(entityId, tarea);
        var usecase = new AgregarTareaUseCase();

        //Act
        when(repository.getEventsBy(entityId.value())).thenReturn(events());
        usecase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("servicioTareaId")
                .syncExecutor(usecase, new RequestCommand<>(command)).orElseThrow();

        //Assert
        var event = (TareaAgregada) events.getDomainEvents().get(0);
        Assertions.assertEquals("servicioTareaId", event.aggregateRootId());
        Assertions.assertEquals("tarea", event.getTarea().identity().value());
        Mockito.verify(repository).getEventsBy("servicioTareaId");
    }

    private List<DomainEvent> events() {
        return List.of(new ServicioIniciado(new Hashtable<>(), new ArrayList<>(), new Hashtable<>()));
    }
}