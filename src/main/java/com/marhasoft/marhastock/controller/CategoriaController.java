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

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.ok(categoriaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable("id") Long id) {
        return new ResponseEntity(categoriaService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> cadastrar(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        try {
            return new ResponseEntity(categoriaService.cadastrar(categoriaDTO), HttpStatus.CREATED);
        }  catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> editar(@PathVariable("id") Long id, @Valid @RequestBody CategoriaDTO categoriaDTO) {
        try {
            return new ResponseEntity(categoriaService.editar(id, categoriaDTO), HttpStatus.OK);
        }  catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@NotNull Long id) {
        categoriaService.deletar(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }
}
