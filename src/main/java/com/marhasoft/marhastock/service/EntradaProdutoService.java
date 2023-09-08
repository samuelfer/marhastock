package com.marhasoft.marhastock.service;

import com.marhasoft.marhastock.dto.EntradaProdutoDTO;
import com.marhasoft.marhastock.model.EntradaProduto;
import com.marhasoft.marhastock.repository.EntradaProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaProdutoService {

    @Autowired
    private EntradaProdutoRepository entradaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<EntradaProduto> getAll() {
        return entradaRepository.findAll();
    }

    public EntradaProduto getById(Long id) {
        return entradaRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Entrada com id: " + id + " não encontrada"));
    }

    public EntradaProdutoDTO cadastrar(EntradaProdutoDTO entradaDTO) {
        EntradaProduto entradaProduto = modelMapper.map(entradaDTO, EntradaProduto.class);
        entradaRepository.save(entradaProduto);
        return entradaDTO;
    }

    public EntradaProdutoDTO editar(EntradaProdutoDTO entradaDTO) {
        getById(entradaDTO.getId());
        EntradaProduto entrada = modelMapper.map(entradaDTO, EntradaProduto.class);
        entradaRepository.save(entrada);
        return entradaDTO;
    }

    public void deletar(Long id) {
        EntradaProduto entrada = getById(id);
        entradaRepository.delete(entrada);
    }
}
