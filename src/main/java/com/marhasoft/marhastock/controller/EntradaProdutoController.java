package com.marhasoft.marhastock.controller;

import com.marhasoft.marhastock.dto.EntradaProdutoDTO;
import com.marhasoft.marhastock.model.EntradaProduto;
import com.marhasoft.marhastock.service.EntradaProdutoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entradas")
public class EntradaProdutoController {

    @Autowired
    private EntradaProdutoService entradaService;

    @GetMapping
    public ResponseEntity<List<EntradaProduto>> getAll() {
        return new ResponseEntity<>(entradaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaProduto> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(entradaService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EntradaProdutoDTO> cadastrar(@Valid @RequestBody EntradaProdutoDTO entradaProdutoDTO) {
       try {
           return new ResponseEntity<>(entradaService.cadastrar(entradaProdutoDTO), HttpStatus.CREATED);
       } catch (Exception e) {
           return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
       }
    }

    @PutMapping
    public ResponseEntity<EntradaProdutoDTO> editar(@Valid @RequestBody EntradaProdutoDTO entradaProdutoDTO) {
        return new ResponseEntity<>(entradaService.editar(entradaProdutoDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@NotNull Long id) {
        entradaService.deletar(id);
        return new ResponseEntity("Registro excluído com sucesso", HttpStatus.OK);
    }
}
