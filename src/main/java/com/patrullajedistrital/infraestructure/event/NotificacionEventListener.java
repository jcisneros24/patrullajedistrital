package com.patrullajedistrital.infraestructure.event;

import com.patrullajedistrital.domain.events.RutaCreadaEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacionEventListener {
  /* CONSUMIDOR 1 --> CUANDO SE CREA UNA RUTA -> NOTIFICA A LOS SERENOS DE LA RUTA */
  @EventListener
  public void handleRutaCreadaEvent(RutaCreadaEvent event) {
    Long idRuta = event.getIdRuta();
    String nombreRuta = event.getNombreRuta();

    // Lógica para enviar notificación por correo electrónico o SMS

    // Simulando notificacion
    System.out.println("Enviando notificación sobre la creación de la ruta '" + nombreRuta + "' (ID: " + idRuta + ")");
  }
}
