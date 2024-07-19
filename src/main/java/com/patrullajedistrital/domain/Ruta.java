package com.patrullajedistrital.domain;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.*;
//import org.axonframework.modelling.command.AggregateIdentifier;
@Entity
@Data
public class Ruta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idRuta;

  @Column(nullable = false)
  private String nombreRuta;

  @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PuntoRuta> puntosDeRuta;
}
