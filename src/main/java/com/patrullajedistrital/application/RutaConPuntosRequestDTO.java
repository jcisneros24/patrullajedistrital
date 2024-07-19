package com.patrullajedistrital.application;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
@Data
public class RutaConPuntosRequestDTO {
  @NotNull
  @NotEmpty
  private String nombreRuta;
  private List<PuntoRutaRequestDTO> puntosDeRuta;
}
