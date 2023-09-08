package com.marhasoft.marhastock.controller;

import com.marhasoft.marhastock.dto.ProdutoDTO;
import com.marhasoft.marhastock.model.Produto;
import com.marhasoft.marhastock.service.ProdutoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return new ResponseEntity<>(produtoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(produtoService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastrar(@Valid @RequestBody ProdutoDTO produtoDTO) {
        return new ResponseEntity<>(produtoService.cadastrar(produtoDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProdutoDTO> editar(@Valid @RequestBody ProdutoDTO produtoDTO) {
        return new ResponseEntity<>(produtoService.editar(produtoDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@NotNull Long id) {
        produtoService.deletar(id);
        return new ResponseEntity("Registro excluído com sucesso", HttpStatus.OK);
    }
}
