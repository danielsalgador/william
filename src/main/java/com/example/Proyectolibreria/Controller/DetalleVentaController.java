package com.example.Proyectolibreria.Controller;


import com.example.Proyectolibreria.Model.Detalle;
import com.example.Proyectolibreria.Service.DetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Detalle_Venta")
public class DetalleVentaController {

    @Autowired
    private DetalleService detalleVentaService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Detalle> detalles = detalleVentaService.findAll();
        return ResponseEntity.ok(Map.of("mensaje", "Lista de detalles obtenida", "detalles", detalles));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Detalle detalleVenta) {
        try {
            Detalle saved = detalleVentaService.save(detalleVenta);
            return ResponseEntity.status(201).body(Map.of("mensaje", "Detalle guardado con éxito", "detalle", saved));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("mensaje", e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return detalleVentaService.findById(id)
                .map(detalle -> ResponseEntity.ok(Map.of("mensaje", "Detalle encontrado", "detalle", detalle)))
                .orElse(ResponseEntity.status(404).body(Map.of("mensaje", "Detalle no encontrado")));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Detalle detalleVenta) {
        return detalleVentaService.updateById(id, detalleVenta) // ✔️ correcto
                .map(updated -> ResponseEntity.ok(Map.of("mensaje", "Detalle actualizado con éxito", "detalle", updated)))
                .orElse(ResponseEntity.status(404).body(Map.of("mensaje", "Detalle no encontrado")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (detalleVentaService.deleteById(id)) {
            return ResponseEntity.ok(Map.of("mensaje", "Detalle eliminado correctamente"));
        } else {
            return ResponseEntity.status(404).body(Map.of("mensaje", "Detalle no encontrado"));
        }
    }

}