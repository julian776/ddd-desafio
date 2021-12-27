package usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.domain.Sexo;
import com.sofka.vuelos.domain.commands.AgregarPasajeroCommand;
import com.sofka.vuelos.domain.events.PasajeroAgregado;
import com.sofka.vuelos.domain.events.ServicioIniciado;
import com.sofka.vuelos.domain.events.VehiculoAgregado;
import com.sofka.vuelos.domain.events.VueloCreado;
import com.sofka.vuelos.domain.vuelo.*;
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
class AgregarPasajeroUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarPasajeroTest(){
        //Arrange
        var vueloId = new VueloId("xxx");

        var identificacion = new Identificacion(124L, "Argina", 27, new Sexo("F"));
        var cuidadosExtra = new CuidadosExtra(false, false, false, false);
        var pasajero = new Pasajero(new PasajeroId("1"), identificacion, cuidadosExtra);

        var command = new AgregarPasajeroCommand(vueloId, pasajero);
        var usecase = new AgregarPasajeroUseCase();

        when(repository.getEventsBy(vueloId.value())).thenReturn(events());
        usecase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx")
                .syncExecutor(usecase, new RequestCommand<>(command)).orElseThrow();

        //Assert
            var event = (PasajeroAgregado) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxx", event.aggregateRootId());
        Assertions.assertEquals(124L, event.getPasajero().identificacion().numeroIdentificacion());
        Assertions.assertEquals("Argina", event.getPasajero().identificacion().nombre());
        Mockito.verify(repository).getEventsBy("xxx");
    }

    private List<DomainEvent> events() {
        var ruta = new Ruta("xx", "xx", new String[0]);
        var bodega = new Bodega(new BodegaId("yy"), new ArrayList<>(), new CapacidadCarga(100, 100, 40, 40));
        var piloto = new Piloto("Daniela", new Carnet("le", new String[0]), 29, new Sexo("F"));
        var avion = new Avion(new AvionId("aaa"), piloto, new ArrayList<>());
        return List.of(new VueloCreado(ruta, new ArrayList<>(), bodega, avion));
    }
}
