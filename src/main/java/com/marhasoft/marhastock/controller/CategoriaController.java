package com.marhasoft.marhastock.controller;

import com.marhasoft.marhastock.dto.CategoriaDTO;
import com.marhasoft.marhastock.model.Categoria;
import com.marhasoft.marhastock.service.CategoriaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<Categoria> getAll() {
        return new ResponseEntity(categoriaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable("id") Long id) {
        return new ResponseEntity(categoriaService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        return new ResponseEntity(categoriaService.cadastrar(categoriaDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Categoria> editar(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        return new ResponseEntity(categoriaService.editar(categoriaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@NotNull Long id) {
        categoriaService.deletar(id);
        return new ResponseEntity("Registro excluído com sucesso", HttpStatus.OK);
    }
}
