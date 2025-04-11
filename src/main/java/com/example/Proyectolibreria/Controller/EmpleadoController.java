package com.example.Proyectolibreria.Controller;

import com.example.Proyectolibreria.Model.Empleado;
import com.example.Proyectolibreria.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Empleado> empleados = empleadoService.findAll();
        return ResponseEntity.ok(Map.of(
                "mensaje", "Lista de empleados obtenida",
                "total", empleados.size(),
                "empleados", empleados
        ));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Empleado empleado) {
        try {
            Empleado saved = empleadoService.save(empleado);
            return ResponseEntity.status(201).body(Map.of(
                    "mensaje", "Empleado guardado con éxito",
                    "empleado", saved
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "mensaje", e.getMessage()
            ));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return empleadoService.findById(id)
                .map(empleado -> ResponseEntity.ok(Map.of(
                        "mensaje", "Empleado encontrado",
                        "empleado", empleado
                )))
                .orElse(ResponseEntity.status(404).body(Map.of(
                        "mensaje", "Empleado no encontrado con ID: " + id
                )));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Empleado empleado) {
        return empleadoService.updateById(id, empleado)
                .map(updated -> ResponseEntity.ok(Map.of(
                        "mensaje", "Empleado actualizado con éxito",
                        "empleado", updated
                )))
                .orElse(ResponseEntity.status(404).body(Map.of(
                        "mensaje", "Empleado no encontrado con ID: " + id
                )));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (EmpleadoService.eliminar(id)) {
            return ResponseEntity.ok(Map.of(
                    "mensaje", "Empleado eliminado correctamente"
            ));
        } else {
            return ResponseEntity.status(404).body(Map.of(
                    "mensaje", "Empleado no encontrado con ID: " + id
            ));
        }
    }
}