package usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.domain.Sexo;
import com.sofka.vuelos.domain.commands.AgregarMercanciaCommand;
import com.sofka.vuelos.domain.events.MercanciaAgregada;
import com.sofka.vuelos.domain.events.VueloCreado;
import com.sofka.vuelos.domain.vuelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AgregarMercanciaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarMercanciaTest() {
        var vueloId = new VueloId("vueloId");

        var command = new AgregarMercanciaCommand(vueloId, new ArrayList<>());
        var usecase = new AgregarMercanciaUseCase();

        //act
        when(repository.getEventsBy(vueloId.value())).thenReturn(events());
        usecase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("vueloId")
                .syncExecutor(usecase, new RequestCommand<>(command)).orElseThrow();

        //Assert
        var event = (MercanciaAgregada) events.getDomainEvents().get(0);
        Assertions.assertEquals("vueloId", event.aggregateRootId());
        Mockito.verify(repository).getEventsBy("vueloId");

    }


    private List<DomainEvent> events() {
        var ruta = new Ruta("xx", "xx", new String[0]);
        var bodega = new Bodega(new BodegaId("yy"), new ArrayList<>(), new CapacidadCarga(100, 100, 40, 40));
        var piloto = new Piloto("Daniela", new Carnet("le", new String[0]), 29, new Sexo("F"));
        var avion = new Avion(new AvionId("aaa"), piloto, new ArrayList<>());
        return List.of(new VueloCreado(ruta, new ArrayList<>(), bodega, avion));
    }
}