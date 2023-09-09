package com.marhasoft.marhastock.service;

import com.marhasoft.marhastock.dto.CategoriaDTO;
import com.marhasoft.marhastock.model.Categoria;
import com.marhasoft.marhastock.repository.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    public Categoria getById(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Categoria com id: " + id + " não encontrada"));
    }

    public CategoriaDTO cadastrar(CategoriaDTO categoriaDTO) {
        categoriaJaCadastrada(categoriaDTO);
        Categoria categoria = new Categoria();
        categoria.setDescricao(categoriaDTO.getDescricao());
        categoriaRepository.save(categoria);
        CategoriaDTO categoriaCadastrada = modelMapper.map(categoria, CategoriaDTO.class);
        return categoriaCadastrada;
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

    private void categoriaJaCadastrada(CategoriaDTO categoriaDTO) {
        Optional<Categoria> categoria = categoriaRepository.findByDescricao(categoriaDTO.getDescricao());
        if (categoria.isPresent()) {
            throw new RuntimeException("Categoria "+ categoriaDTO.getDescricao() + " Já cadastrada");
        }
    }
}
