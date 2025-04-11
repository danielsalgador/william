package com.example.Proyectolibreria.Service;

import com.example.Proyectolibreria.Model.Venta;
import com.example.Proyectolibreria.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    public Venta save(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Venta findById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public void deleteById(long id) {
        ventaRepository.deleteById(id);
    }



}




