package com.patrullajedistrital.application;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
@Data
public class PuntoRutaRequestDTO {

  @NotNull
  @NotEmpty
  private Double latitud;
  @NotNull
  @NotEmpty
  private Double longitud;
  @NotNull
  @NotEmpty
  private String descripcion;
}
