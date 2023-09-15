package com.marhasoft.marhastock.controller;

import com.marhasoft.marhastock.dto.ClienteDTO;
import com.marhasoft.marhastock.model.Cliente;
import com.marhasoft.marhastock.service.ClienteService;
import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> getAll() {
        return clienteService.getAll();
    }

    @GetMapping("/{id}")
    public ClienteDTO getById(@PathVariable @Positive @NotNull Long id) {
        return clienteService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ClienteDTO cadastrar(@Valid @RequestBody ClienteDTO clienteDTO) {
        return clienteService.cadastrar(clienteDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ClienteDTO editar(@PathVariable @Nonnull @Positive Long id, @Valid @RequestBody ClienteDTO clienteDTO) {
        return clienteService.editar(id, clienteDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable @Nonnull @Positive Long id) {
        clienteService.deletar(id);
    }
}
