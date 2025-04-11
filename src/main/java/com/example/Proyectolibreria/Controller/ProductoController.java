package com.example.Proyectolibreria.Controller;

import com.example.Proyectolibreria.Model.Producto;
import com.example.Proyectolibreria.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Producto> productos = productoService.findAll();
        return ResponseEntity.ok(Map.of("mensaje", "Lista de productos obtenida", "productos", productos));
    }

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Producto producto) {
        try {
            Producto saved = productoService.save(producto);
            return ResponseEntity.status(201).body(Map.of("mensaje", "Producto creado exitosamente", "producto", saved));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        if (producto != null) {
            return ResponseEntity.ok(Map.of("mensaje", "Producto encontrado", "producto", producto));
        } else {
            return ResponseEntity.status(404).body(Map.of("mensaje", "Producto no encontrado"));
        }
    }


    // Eliminar un producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            productoService.eliminar(id);
            return ResponseEntity.ok(Map.of("mensaje", "Producto eliminado correctamente"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(Map.of("mensaje", "Producto no encontrado"));
        }
    }
}
