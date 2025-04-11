package com.example.Proyectolibreria.Repository;

import com.example.Proyectolibreria.Model.Detalle;
import com.example.Proyectolibreria.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

}
