package com.patrullajedistrital.application;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
@Data
public class PuntoRutaRequestDto {

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
