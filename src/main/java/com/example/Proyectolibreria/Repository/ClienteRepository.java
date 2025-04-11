package com.example.Proyectolibreria.Repository;

import com.example.Proyectolibreria.Model.Cliente;
import com.example.Proyectolibreria.Model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}