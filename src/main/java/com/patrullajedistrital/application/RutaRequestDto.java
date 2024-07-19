package com.patrullajedistrital.application;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.*;

@Data
public class RutaRequestDto {
  @NotNull
  @NotEmpty
  private String nombreRuta;
}
