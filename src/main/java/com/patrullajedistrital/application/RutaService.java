package com.patrullajedistrital.application;

import com.patrullajedistrital.domain.PuntoRuta;
import com.patrullajedistrital.domain.Ruta;
import com.patrullajedistrital.domain.events.RutaCreadaEvent;
import com.patrullajedistrital.domain.events.RutaObtenidaEvent;
import com.patrullajedistrital.infraestructure.event.repository.PuntoRutaRepository;
import com.patrullajedistrital.infraestructure.event.repository.RutaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class RutaService {

  @Autowired
  private RutaRepository rutaRepository;
  @Autowired
  private PuntoRutaRepository puntoRutaRepository;
  @Autowired
  private ApplicationEventPublisher eventPublisher;
  @Transactional

  // Método para crear una ruta con sus puntos de ruta
  public Ruta crearRutaConPuntos(RutaConPuntosRequestDTO rutaConPuntosRequestDTO) {
    Ruta nuevaRuta = new Ruta();
    nuevaRuta.setNombreRuta(rutaConPuntosRequestDTO.getNombreRuta());
    Ruta rutaGuardada = rutaRepository.save(nuevaRuta);
    // Publicar evento de ruta creada
    eventPublisher.publishEvent(new RutaCreadaEvent(this, rutaGuardada.getIdRuta(), rutaGuardada.getNombreRuta()));
    // Guardar puntos de ruta
    List<PuntoRuta> puntosDeRuta = new ArrayList<>();
    for (PuntoRutaRequestDTO puntoDTO : rutaConPuntosRequestDTO.getPuntosDeRuta()) {
      PuntoRuta puntoRuta = new PuntoRuta();
      puntoRuta.setLatitud(puntoDTO.getLatitud());
      puntoRuta.setLongitud(puntoDTO.getLongitud());
      puntoRuta.setDescripcion(puntoDTO.getDescripcion());
      puntoRuta.setRuta(rutaGuardada);
      puntosDeRuta.add(puntoRuta);
    }
    // Guardar todos los puntos de ruta
    puntoRutaRepository.saveAll(puntosDeRuta);
    return rutaGuardada;
   }


  // Método para obtener una ruta con sus puntos de ruta
  @Transactional(readOnly = true)
  public RutaConPuntosResponseDTO obtenerRutaConPuntos(Long idRuta) {
    Ruta ruta = rutaRepository.findById(idRuta)
      .orElseThrow(() -> new RuntimeException("Ruta no encontrada"));

    RutaConPuntosResponseDTO response = new RutaConPuntosResponseDTO();
    response.setIdRuta(ruta.getIdRuta());
    response.setNombreRuta(ruta.getNombreRuta());


    List<RutaConPuntosResponseDTO.PuntoRutaResponseDTO> puntosDeRuta = new ArrayList<>();
    for (PuntoRuta punto : ruta.getPuntosDeRuta()) {
      RutaConPuntosResponseDTO.PuntoRutaResponseDTO puntoResponse = new RutaConPuntosResponseDTO.PuntoRutaResponseDTO();
      puntoResponse.setIdPuntoRuta(punto.getIdPuntoRuta());
      puntoResponse.setLatitud(punto.getLatitud());
      puntoResponse.setLongitud(punto.getLongitud());
      puntoResponse.setDescripcion(punto.getDescripcion());
      puntosDeRuta.add(puntoResponse);
    }
    response.setPuntosDeRuta(puntosDeRuta);

    // Publicar evento de ruta obtenida
    eventPublisher.publishEvent(new RutaObtenidaEvent(this, idRuta));

    return response;
  }


}
