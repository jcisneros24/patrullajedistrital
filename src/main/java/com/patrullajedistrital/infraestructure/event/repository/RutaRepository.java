package com.patrullajedistrital.infraestructure.event.repository;


import com.patrullajedistrital.domain.Ruta;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Long> {
}
