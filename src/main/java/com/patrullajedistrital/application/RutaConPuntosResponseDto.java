package com.patrullajedistrital.application;

// DTO para la respuesta de Ruta con sus puntos de ruta
import lombok.Data;
import java.util.List;

@Data
public class RutaConPuntosResponseDto {
  private Long idRuta;
  private String nombreRuta;
  private List<PuntoRutaResponseDTO> puntosDeRuta;

  @Data
  public static class PuntoRutaResponseDTO {
    private Long idPuntoRuta;
    private Double latitud;
    private Double longitud;
    private String descripcion;
  }
}














