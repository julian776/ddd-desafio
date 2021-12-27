package usecase;

import co.com.sofka.business.generic.UseCase;

public class NotificarTareaFinalizadaUseCase extends UseCase<UseCase.RequestEvent, UseCase.ResponseValues> {
    @Override
    public void executeUseCase(RequestEvent tareaFinalizadaRequestEvent) {
        var event = tareaFinalizadaRequestEvent.getDomainEvent();
        System.out.println("Tarea finalizada " + event.aggregateRootId());


        emit().onResponse(new ResponseValues() {
            @Override
            public String toString() {
                return super.toString();
            }
        });
    }
}
