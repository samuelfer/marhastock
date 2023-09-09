package com.marhasoft.marhastock.controller;

import com.marhasoft.marhastock.dto.FornecedorDTO;
import com.marhasoft.marhastock.model.Fornecedor;
import com.marhasoft.marhastock.service.FornecedorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> getAll() {
        return new ResponseEntity<>(fornecedorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(fornecedorService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FornecedorDTO> cadastrar(@Valid @RequestBody FornecedorDTO fornecedorDTO) {
        try {
            return new ResponseEntity<>(fornecedorService.cadastrar(fornecedorDTO), HttpStatus.CREATED);
        }  catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<FornecedorDTO> editar(@Valid @RequestBody FornecedorDTO fornecedorDTO) {
        try {
            return new ResponseEntity<>(fornecedorService.editar(fornecedorDTO), HttpStatus.OK);
        }  catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@NotNull Long id) {
        fornecedorService.deletar(id);
        return new ResponseEntity("Registro excluído com sucesso", HttpStatus.OK);
    }
}
