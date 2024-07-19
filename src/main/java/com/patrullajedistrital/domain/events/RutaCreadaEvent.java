package com.patrullajedistrital.domain.events;
import org.springframework.context.ApplicationEvent;


public class RutaCreadaEvent extends ApplicationEvent {
  private Long idRuta;
  private String nombreRuta;

  public RutaCreadaEvent(Object source, Long idRuta, String nombreRuta) {
    super(source);
    this.idRuta = idRuta;
    this.nombreRuta = nombreRuta;
  }

  // Getters
  public Long getIdRuta() {
    return idRuta;
  }

  public String getNombreRuta() {
    return nombreRuta;
  }
}
