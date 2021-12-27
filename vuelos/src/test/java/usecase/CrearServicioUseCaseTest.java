package usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.vuelos.domain.commands.CrearServicioPremiumCommand;
import com.sofka.vuelos.domain.events.ServicioIniciado;
import com.sofka.vuelos.domain.serviciopremium.ServicioPremiumId;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Hashtable;


class CrearServicioUseCaseTest {

    @Test
    void servicioCreadoTest(){

        //Arrange


        var command = new CrearServicioPremiumCommand(new ServicioPremiumId("servicio"), new Hashtable<>(), new ArrayList<>(), new Hashtable<>());
        var usecase = new CrearServicioUseCase();

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //Arrange
        ServicioIniciado event = (ServicioIniciado) events.getDomainEvents().get(0);
        Assertions.assertEquals("servicio", event.aggregateRootId());
    }
}