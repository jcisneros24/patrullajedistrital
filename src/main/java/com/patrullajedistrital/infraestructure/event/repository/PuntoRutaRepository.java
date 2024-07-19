package com.patrullajedistrital.infraestructure.event.repository;

import com.patrullajedistrital.domain.PuntoRuta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PuntoRutaRepository extends JpaRepository<PuntoRuta, Long>{
}
