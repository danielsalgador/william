package com.example.Proyectolibreria.Service;

import com.example.Proyectolibreria.Model.Detalle;
import com.example.Proyectolibreria.Repository.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleService {

    @Autowired
    private DetalleRepository detalleVentaRepository;

    public List<Detalle> findAll() {
        return detalleVentaRepository.findAll();
    }

    public Detalle save(Detalle detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    public Optional<Detalle> findById(Long id) {
        return detalleVentaRepository.findById(id);
    }

    public boolean deleteById(long id) {
        if (detalleVentaRepository.existsById(id)) {
            detalleVentaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Detalle> updateById(Long id, Detalle detalleActualizado) {
        return detalleVentaRepository.findById(id).map(detalle -> {
            detalle.setCantidad(detalleActualizado.getCantidad());
            detalle.setPrecioUnitario(detalleActualizado.getPrecioUnitario());
            detalle.setProducto(detalleActualizado.getProducto());
            detalle.setVenta(detalleActualizado.getVenta());

            return detalleVentaRepository.save(detalle);
        });
    }


}
