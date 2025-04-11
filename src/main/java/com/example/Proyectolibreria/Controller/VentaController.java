package com.example.Proyectolibreria.Controller;

import com.example.Proyectolibreria.Model.Venta;
import com.example.Proyectolibreria.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Venta")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    // Obtener todas las ventas
    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Venta> ventas = ventaService.findAll();
        return ResponseEntity.ok(Map.of("mensaje", "Lista de ventas obtenida", "ventas", ventas));
    }

    // Crear una nueva venta
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Venta venta) {
        try {
            Venta saved = ventaService.save(venta);
            return ResponseEntity.status(201).body(Map.of("mensaje", "Venta creada exitosamente", "venta", saved));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // Obtener una venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Venta venta = ventaService.findById(id);
        if (venta != null) {
            return ResponseEntity.ok(Map.of("mensaje", "Venta encontrada", "venta", venta));
        } else {
            return ResponseEntity.status(404).body(Map.of("mensaje", "Venta no encontrada"));
        }
    }



    // Eliminar una venta por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            ventaService.deleteById(id);
            return ResponseEntity.ok(Map.of("mensaje", "Venta eliminada correctamente"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(Map.of("mensaje", "Venta no encontrada"));
        }
    }
}
