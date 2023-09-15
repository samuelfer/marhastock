package com.marhasoft.marhastock.service;

import com.marhasoft.marhastock.dto.ClienteDTO;
import com.marhasoft.marhastock.exception.RecordNotFoundException;
import com.marhasoft.marhastock.model.Cliente;
import com.marhasoft.marhastock.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    private ConverteDados conversor = new ConverteDados();

    public List<ClienteDTO> getAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(cliente -> conversor.modelToDTO(cliente, ClienteDTO.class)).toList();
    }

    public ClienteDTO getById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (!cliente.isPresent()) {
            throw new RecordNotFoundException("Cliente com id: " + id + " não encontrado");
        }
        return conversor.modelToDTO(cliente.get(), ClienteDTO.class);
    }

    public ClienteDTO cadastrar(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        Cliente clienteSalvo = clienteRepository.save(cliente.clienteDtoToCliente(clienteDTO));
        return conversor.modelToDTO(clienteSalvo, ClienteDTO.class);
    }

    public ClienteDTO editar(Long id, ClienteDTO clienteDTO) {
        getById(id);
        Cliente cliente = new Cliente();
        Cliente clienteSalvo = clienteRepository.save(cliente.clienteDtoToCliente(clienteDTO));
        return conversor.modelToDTO(clienteSalvo, ClienteDTO.class);
    }

    public void deletar(Long id) {
        getById(id);
        clienteRepository.deleteById(id);
    }
}
