package com.example.Proyectolibreria.Service;


import com.example.Proyectolibreria.Model.Proveedor;
import com.example.Proyectolibreria.Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

    public Proveedor save(Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }

    public Proveedor findById(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public void deleteById(long id) {
        proveedorRepository.deleteById(id);
    }

}
