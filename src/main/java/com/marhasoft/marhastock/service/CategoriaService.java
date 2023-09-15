package com.marhasoft.marhastock.service;

import com.marhasoft.marhastock.dto.CategoriaDTO;
import com.marhasoft.marhastock.exception.RecordNotFoundException;
import com.marhasoft.marhastock.exception.UniqueException;
import com.marhasoft.marhastock.model.Categoria;
import com.marhasoft.marhastock.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    private ConverteDados conversor = new ConverteDados();

    public List<CategoriaDTO> getAll() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream()
        .map(categoria -> conversor.modelToDTO(categoria, CategoriaDTO.class)).toList();
    }

    public CategoriaDTO getById(Long id) {
       Optional<Categoria> categoria = categoriaRepository.findById(id);
       if (!categoria.isPresent()) {
           throw  new RecordNotFoundException("Categoria com id: " + id + " não encontrada");
       }
       return conversor.modelToDTO(categoria.get(), CategoriaDTO.class);
    }

    public CategoriaDTO cadastrar(CategoriaDTO categoriaDTO) {
        categoriaJaCadastrada(categoriaDTO.getDescricao());
        Categoria categoria = new Categoria();
        categoria.setDescricao(categoriaDTO.getDescricao());
        categoriaRepository.save(categoria);
        return conversor.modelToDTO(categoria, CategoriaDTO.class);
    }

    public CategoriaDTO editar(Long id, CategoriaDTO categoriaDTO) {
        getById(id);
        Categoria categoria = new Categoria();
        categoria.setId(id);
        categoria.setDescricao(categoriaDTO.getDescricao());
        categoriaRepository.save(categoria);
        return conversor.modelToDTO(categoria, CategoriaDTO.class);
    }

    public void deletar(Long id) {
        CategoriaDTO categoria = getById(id);
        categoriaRepository.deleteById(categoria.getId());
    }

    private void categoriaJaCadastrada(String descricao) {
        Optional<Categoria> categoria = categoriaRepository.findByDescricao(descricao);
        if (categoria.isPresent()) {
            throw new UniqueException("Categoria "+ descricao + " Já cadastrada no sistema");
        }
    }
}
