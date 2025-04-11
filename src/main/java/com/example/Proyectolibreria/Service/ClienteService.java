package com.example.Proyectolibreria.Service;

import com.example.Proyectolibreria.Model.Cliente;
import com.example.Proyectolibreria.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente updateById(Long id, Cliente clienteActualizado) {
        Cliente clienteExistente = clienteRepository.findById(id).orElse(null);
        if (clienteExistente != null) {
            clienteExistente.setNombre(clienteActualizado.getNombre());
            clienteExistente.setCedula(clienteActualizado.getCedula());
            clienteExistente.setTelefono(clienteActualizado.getTelefono());
            clienteExistente.setCorreo(clienteActualizado.getCorreo());
            return clienteRepository.save(clienteExistente);
        }
        return null;
    }

    public void deleteById(long id) {
        clienteRepository.deleteById(id);
    }
}
