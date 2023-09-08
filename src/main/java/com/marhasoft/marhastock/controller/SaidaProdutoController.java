package com.marhasoft.marhastock.controller;

import com.marhasoft.marhastock.dto.SaidaProdutoDTO;
import com.marhasoft.marhastock.model.SaidaProduto;
import com.marhasoft.marhastock.service.SaidaProdutoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("saidas")
public class SaidaProdutoController {

    @Autowired
    private SaidaProdutoService saidaService;

    @GetMapping
    public ResponseEntity<List<SaidaProduto>> getAll() {
        return new ResponseEntity<>(saidaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaidaProduto> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(saidaService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SaidaProdutoDTO> cadastrar(@Valid @RequestBody SaidaProdutoDTO saidaDTO) {
        return new ResponseEntity<>(saidaService.cadastrar(saidaDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<SaidaProdutoDTO> editar(@Valid @RequestBody SaidaProdutoDTO saidaDTO) {
        return new ResponseEntity<>(saidaService.editar(saidaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@NotNull Long id) {
        saidaService.deletar(id);
        return new ResponseEntity("Registro excluído com sucesso", HttpStatus.OK);
    }
}
