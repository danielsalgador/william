package com.example.Proyectolibreria.Repository;

import com.example.Proyectolibreria.Model.Detalle;
import com.example.Proyectolibreria.Model.Empleado;
import com.example.Proyectolibreria.Service.EmpleadoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Long> {
}

