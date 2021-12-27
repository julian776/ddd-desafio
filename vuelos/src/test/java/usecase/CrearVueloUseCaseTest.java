package usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sofka.vuelos.domain.Sexo;
import com.sofka.vuelos.domain.commands.CrearVueloCommand;
import com.sofka.vuelos.domain.events.VueloCreado;
import com.sofka.vuelos.domain.vuelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CrearVueloUseCaseTest {

    @Test
    void crearVueloTest(){
        //Arrange
        VueloId vueloId = new VueloId("vuelo");
        var paradas = new String[0];
        Ruta ruta = new Ruta("xx", "yy", paradas);
        //CrearBodega
        BodegaId bodegaId = new BodegaId("bodega");
        var capacidadCarga = new CapacidadCarga(100, 100, 40, 40);
        var bodega = new Bodega(bodegaId, new ArrayList<>(), capacidadCarga);
        //CrearAvion
        AvionId avionId = new AvionId("avion");
        var carnet = new Carnet("ffff", new String[0]);
        var piloto = new Piloto("Alex", carnet, 41, new Sexo("M"));
        var avion = new Avion(avionId, piloto, new ArrayList<>());
        //Command-UseCase
        var command = new CrearVueloCommand(vueloId, ruta, new ArrayList<>(), bodega, avion);
        var useCase = new CrearVueloUseCase();

        //Act;
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //Assert
        VueloCreado event = (VueloCreado)events.getDomainEvents().get(0);
        Assertions.assertEquals("vuelo", event.aggregateRootId());
        Assertions.assertEquals(100, event.getBodega().getCapacidadCarga().capacidadTotalMercancia());
        Assertions.assertEquals("Alex", event.getAvion().getPiloto().nombre());
    }
}