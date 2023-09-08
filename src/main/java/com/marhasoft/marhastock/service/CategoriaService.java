package com.marhasoft.marhastock.service;

import com.marhasoft.marhastock.dto.CategoriaDTO;
import com.marhasoft.marhastock.model.Categoria;
import com.marhasoft.marhastock.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    public Categoria getById(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Categoria com id: " + id + " não encontrada"));
    }

    public CategoriaDTO cadastrar(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setDescricao(categoriaDTO.getDescricao());
        categoriaRepository.save(categoria);
        return categoriaDTO;
    }

    public CategoriaDTO editar(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoria = getById(id);
        categoria.setDescricao(categoriaDTO.getDescricao());
        categoriaRepository.save(categoria);
        return categoriaDTO;
    }

    public void deletar(Long id) {
        Categoria categoria = getById(id);
        categoriaRepository.delete(categoria);
    }
}
