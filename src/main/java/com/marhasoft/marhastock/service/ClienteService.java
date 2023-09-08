package com.marhasoft.marhastock.service;

import com.marhasoft.marhastock.dto.ClienteDTO;
import com.marhasoft.marhastock.model.Cliente;
import com.marhasoft.marhastock.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Cliente getById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cliente com id: " + id + " não encontrado"));
    }

    public ClienteDTO cadastrar(ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        clienteRepository.save(cliente);
        return clienteDTO;
    }

    public ClienteDTO editar(ClienteDTO clienteDTO) {
        getById(clienteDTO.getId());
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        clienteRepository.save(cliente);
        return clienteDTO;
    }

    public void deletar(Long id) {
        Cliente cliente = getById(id);
        clienteRepository.delete(cliente);
    }
}
