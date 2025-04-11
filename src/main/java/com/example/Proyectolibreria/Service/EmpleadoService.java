package com.example.Proyectolibreria.Service;

import com.example.Proyectolibreria.Model.Detalle;
import com.example.Proyectolibreria.Model.Empleado;
import com.example.Proyectolibreria.Model.Producto;
import com.example.Proyectolibreria.Repository.DetalleRepository;
import com.example.Proyectolibreria.Repository.EmpleadoRepository;
import com.example.Proyectolibreria.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    public Empleado save(Empleado empleado) {
        if (empleado.getNombre() == null || empleado.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del empleado no puede estar vacío");
        }
        if (empleado.getCargo() == null || empleado.getCargo().isBlank()) {
            throw new IllegalArgumentException("El cargo del empleado no puede estar vacío");
        }
        if (empleado.getTelefono() == null || empleado.getTelefono().isBlank()) {
            throw new IllegalArgumentException("El teléfono del empleado no puede estar vacío");
        }
        return empleadoRepository.save(empleado);
    }

    public Empleado findById(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    public Empleado updateById(Long id, Empleado empleadoActualizado) {
        return empleadoRepository.findById(id).map(empleado -> {
            empleado.setNombre(empleadoActualizado.getNombre());
            empleado.setCargo(empleadoActualizado.getCargo());
            empleado.setTelefono(empleadoActualizado.getTelefono());
            return empleadoRepository.save(empleado);
        }).orElse(null);
    }

    public boolean eliminar(Long id) {
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public Optional<Empleado> findById(Long id) {
        return empleadoRepository.findById(id);
    }
}
