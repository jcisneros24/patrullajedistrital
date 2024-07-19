package com.patrullajedistrital.interfaces;
/* SWAGGER*/
import com.patrullajedistrital.application.RutaConPuntosResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/* PAQUETES */
import com.patrullajedistrital.application.RutaConPuntosRequestDTO;
import com.patrullajedistrital.application.RutaService;
import com.patrullajedistrital.domain.Ruta;

/* spring */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rutas")

public class RutaController {

  @Autowired
  private RutaService rutaService;


  @Operation(summary = "Registrar ruta con sus puntos de rutas")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Register ruta received successfully"),
    @ApiResponse(responseCode = "400", description = "Bad request, validation errors"),
    @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  @PostMapping("/rutas-con-puntos")
  public ResponseEntity<Ruta> crearRutaConPuntos(@RequestBody RutaConPuntosRequestDTO rutaConPuntosRequestDTO) {
    Ruta rutaCreada = rutaService.crearRutaConPuntos(rutaConPuntosRequestDTO);
    return ResponseEntity.ok(rutaCreada);
  }



  @Operation(summary = "Consultar ruta con sus puntos de rutas")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Ruta retrieved successfully"),
    @ApiResponse(responseCode = "404", description = "Ruta not found"),
    @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  @GetMapping("/{idRuta}/con-puntos")
  public ResponseEntity<RutaConPuntosResponseDTO> obtenerRutaConPuntos(@PathVariable Long idRuta) {
    RutaConPuntosResponseDTO rutaConPuntos = rutaService.obtenerRutaConPuntos(idRuta);
    return ResponseEntity.ok(rutaConPuntos);
  }
}
