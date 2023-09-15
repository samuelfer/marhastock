package com.marhasoft.marhastock.controller;

import com.marhasoft.marhastock.dto.CategoriaDTO;
import com.marhasoft.marhastock.service.CategoriaService;
import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaDTO> getAll() {
        return categoriaService.getAll();
    }

    @GetMapping("/{id}")
    public CategoriaDTO getById(@PathVariable @Positive @NotNull Long id) {
        return categoriaService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CategoriaDTO cadastrar(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.cadastrar(categoriaDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CategoriaDTO editar(@PathVariable @Nonnull @Positive Long id, @Valid @RequestBody @Nonnull CategoriaDTO categoriaDTO) {
        return categoriaService.editar(id, categoriaDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable @Nonnull @Positive Long id) {
        categoriaService.deletar(id);
    }
}
