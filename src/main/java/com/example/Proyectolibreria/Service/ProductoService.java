package com.example.Proyectolibreria.Service;

import com.example.Proyectolibreria.Model.Detalle;
import com.example.Proyectolibreria.Model.Producto;
import com.example.Proyectolibreria.Repository.DetalleRepository;
import com.example.Proyectolibreria.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Producto save(Producto producto) {
        if (producto.getNombre() == null || producto.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        if (producto.getPrecio() == null) {
            throw new IllegalArgumentException("El precio del producto no puede ser nulo");
        }
        if (producto.getPrecio().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio del producto no puede ser negativo");
        }
        if (producto.getStock() == null || producto.getStock() < 0) {
            throw new IllegalArgumentException("El stock del producto no puede ser negativo o nulo");
        }
        if (producto.getProveedor() == null) {
            throw new IllegalArgumentException("El proveedor del producto no puede ser nulo");
        }
        return productoRepository.save(producto);
    }

    public Producto findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto updateById(Long id, Producto productoActualizado) {
        return productoRepository.findById(id).map(producto -> {
            producto.setNombre(productoActualizado.getNombre());
            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setStock(productoActualizado.getStock());
            producto.setProveedor(productoActualizado.getProveedor());
            return productoRepository.save(producto);
        }).orElse(null);
    }

    public boolean eliminar(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
