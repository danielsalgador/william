package com.example.Proyectolibreria.Controller;

import com.example.Proyectolibreria.Model.Proveedor;
import com.example.Proyectolibreria.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    // Obtener todos los proveedores
    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Proveedor> proveedores = proveedorService.findAll();
        return ResponseEntity.ok(Map.of("mensaje", "Lista de proveedores obtenida", "proveedores", proveedores));
    }

    // Crear un nuevo proveedor
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Proveedor proveedor) {
        try {
            Proveedor saved = proveedorService.save(proveedor);
            return ResponseEntity.status(201).body(Map.of("mensaje", "Proveedor creado exitosamente", "proveedor", saved));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // Obtener un proveedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Proveedor proveedor = proveedorService.findById(id);
        if (proveedor != null) {
            return ResponseEntity.ok(Map.of("mensaje", "Proveedor encontrado", "proveedor", proveedor));
        } else {
            return ResponseEntity.status(404).body(Map.of("mensaje", "Proveedor no encontrado"));
        }
    }

    // Eliminar un proveedor por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            proveedorService.deleteById(id);
            return ResponseEntity.ok(Map.of("mensaje", "Proveedor eliminado correctamente"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(Map.of("mensaje", "Proveedor no encontrado"));
        }
    }
}
