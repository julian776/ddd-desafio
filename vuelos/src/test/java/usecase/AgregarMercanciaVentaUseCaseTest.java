package usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.vuelos.domain.Sexo;
import com.sofka.vuelos.domain.commands.AgregarMercanciaVentaCommand;
import com.sofka.vuelos.domain.events.MercanciaAgregadaVentas;
import com.sofka.vuelos.domain.events.ServicioIniciado;
import com.sofka.vuelos.domain.events.VehiculoAgregado;
import com.sofka.vuelos.domain.events.VentaEfectuada;
import com.sofka.vuelos.domain.venta.*;
import com.sofka.vuelos.domain.vuelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PipedInputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AgregarMercanciaVentaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarMercanciaEnVentasTest(){
        var ventaId = new VentaId("ventaId");
        var piezas = new ArrayList<PiezaMercancia>();
        var etiqueta = new Etiqueta(false, "xx", "yy", "JA");
        var pieza = new PiezaMercancia(20F, 10, "xx", etiqueta);
        piezas.add(pieza);
        var command = new AgregarMercanciaVentaCommand(ventaId, piezas);
        var usecase = new AgregarMercanciaVentaUseCase();

        //Act
        when(repository.getEventsBy(ventaId.value())).thenReturn(events());
        usecase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("ventaId")
                .syncExecutor(usecase, new RequestCommand<>(command)).orElseThrow();

        //Assert
        var event = (MercanciaAgregadaVentas) events.getDomainEvents().get(0);
        Assertions.assertEquals("ventaId", event.aggregateRootId());
        Mockito.verify(repository).getEventsBy("ventaId");
    }

    private List<DomainEvent> events() {
        var factura = new Factura(new FacturaId("fff"), new Identificacion(1L, "RE", 10, new Sexo("M")), 110D);
        Ruta ruta = new Ruta("xx", "yy", new String[0]);
        var tiquete = new Tiquete(new TiqueteId("ttt"), ruta, new VueloId("aaaa"));
        var mercancia = new Mercancia(new MercanciaId("mmm"), true, new ArrayList<>());
        return List.of(new VentaEfectuada(new VentaId("yyy"), factura, new VueloId("aaa"), tiquete, mercancia));
    }
}
