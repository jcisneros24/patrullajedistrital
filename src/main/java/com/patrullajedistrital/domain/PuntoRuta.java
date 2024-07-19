package com.patrullajedistrital.domain;


import jakarta.persistence.*;
import lombok.*;
@Entity
@Data

public class PuntoRuta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idPuntoRuta;
  @Column(nullable = false)
  private Double latitud;
  @Column(nullable = false)
  private Double longitud;
  @Column(nullable = false)
  private String descripcion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_ruta")
  private Ruta ruta;

}
