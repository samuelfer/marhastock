package com.marhasoft.marhastock.controller;

import com.marhasoft.marhastock.dto.ClienteDTO;
import com.marhasoft.marhastock.model.Cliente;
import com.marhasoft.marhastock.service.ClienteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return new ResponseEntity<>(clienteService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(clienteService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastrar(@Valid @RequestBody ClienteDTO clienteDTO) {
        return new ResponseEntity<>(clienteService.cadastrar(clienteDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> editar(@Valid @RequestBody ClienteDTO clienteDTO) {
        return new ResponseEntity<>(clienteService.editar(clienteDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@NotNull Long id) {
        clienteService.deletar(id);
        return new ResponseEntity("Registro excluído com sucesso", HttpStatus.OK);
    }
}
