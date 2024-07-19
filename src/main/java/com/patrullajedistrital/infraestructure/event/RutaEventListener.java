package com.patrullajedistrital.infraestructure.event;
import com.patrullajedistrital.domain.events.RutaCreadaEvent;
import com.patrullajedistrital.domain.events.RutaObtenidaEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RutaEventListener {

  @EventListener
  public void onRutaCreada(RutaCreadaEvent event) {
    // Lógica para manejar el evento de ruta creada
    System.out.println("Evento de Ruta Creada recibido - ID: " + event.getIdRuta() + ", Nombre: " + event.getNombreRuta());
    // Simular notificación a usuarios interesados
    notificarUsuarios(event.getIdRuta(), event.getNombreRuta());
    // Simular actualización en un sistema externo
    actualizarSistemaExterno(event.getIdRuta());
  }

  public void onRutaObtenida(RutaObtenidaEvent event) {
    // Lógica para manejar el evento de ruta creada
    System.out.println("Evento de Ruta Obtenida recibido - ID: " + event.getIdRuta());

  }


  private void notificarUsuarios(Long rutaId, String nombreRuta) {
    // Aquí implementarías la lógica real para notificar a los usuarios interesados
    System.out.println("Notificación enviada a los serenos y patrullas sobre la nueva ruta: " + nombreRuta);
  }

  private void actualizarSistemaExterno(Long rutaId) {
    // Aquí implementarías la lógica real para actualizar el sistema externo
    System.out.println("Actualización realizada en sistema externo para la ruta con ID: " + rutaId);
  }
}
