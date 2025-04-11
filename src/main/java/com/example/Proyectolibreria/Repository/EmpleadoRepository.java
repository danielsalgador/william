package com.example.Proyectolibreria.Repository;

import com.example.Proyectolibreria.Model.Empleado;
import com.example.Proyectolibreria.Service.EmpleadoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}

