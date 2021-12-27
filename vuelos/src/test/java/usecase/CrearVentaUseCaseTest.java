package usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.vuelos.domain.Sexo;
import com.sofka.vuelos.domain.commands.CrearVentaCommand;
import com.sofka.vuelos.domain.events.VentaEfectuada;
import com.sofka.vuelos.domain.venta.*;
import com.sofka.vuelos.domain.vuelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CrearVentaUseCaseTest{

    @Test
    void ventaCreadaTest(){

        //Arrange
        VentaId ventaId = new VentaId("venta");
        var identificacion = new Identificacion(454L, "Pol", 31, new Sexo("M"));
        var factura = new Factura(new FacturaId("yyyy"), identificacion, 450D);
        VueloId vueloId = new VueloId("vuelo");
        //tiquete
        var tiqueteId = new TiqueteId("tiquete");
        var paradas = new String[0];
        Ruta ruta = new Ruta("xx", "yy", paradas);
        var tiquete = new Tiquete(tiqueteId, ruta, vueloId);
        //mercancia
        var mercanciaId = new MercanciaId("mercancia");
        var listaPiezas = new ArrayList<PiezaMercancia>();
        var etiqueta = new Etiqueta(false, "xx", "yy", "JA");
        PiezaMercancia pieza = new PiezaMercancia(20F, 10, "xx", etiqueta);
        listaPiezas.add(pieza);
        var mercancia = new Mercancia(mercanciaId, true, listaPiezas);

        var command = new CrearVentaCommand(ventaId, factura, vueloId, tiquete, mercancia);
        var usecase = new CrearVentaUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //Assert
        VentaEfectuada event = (VentaEfectuada) events.getDomainEvents().get(0);
        Assertions.assertEquals(450D, event.getFactura().getTotal());
        Assertions.assertEquals("vuelo", event.getVueloId().value());
    }
}