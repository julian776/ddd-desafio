package usecase;

import com.sofka.vuelos.domain.serviciopremium.TareaId;

public interface EnviarEmailService {
    boolean send(TareaId tareaId, String correo, String body);
}
