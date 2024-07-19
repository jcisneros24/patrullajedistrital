package com.patrullajedistrital.domain.events;
import org.springframework.context.ApplicationEvent;

public class RutaObtenidaEvent extends ApplicationEvent {

  private Long idRuta;

  public RutaObtenidaEvent(Object source, Long idRuta) {
    super(source);
    this.idRuta = idRuta;
  }

  public Long getIdRuta() {
    return idRuta;
  }
}
