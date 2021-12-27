package usecase;

import com.sofka.vuelos.domain.vuelo.VueloId;

public interface EnviarCambioVueloService {
    boolean sendCambioVuelo(VueloId vueloId, String correo, String body);
}
