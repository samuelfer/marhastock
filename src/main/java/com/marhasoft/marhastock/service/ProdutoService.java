package com.marhasoft.marhastock.service;

import com.marhasoft.marhastock.dto.ProdutoDTO;
import com.marhasoft.marhastock.model.Produto;
import com.marhasoft.marhastock.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    public Produto getById(Long id) {
        return produtoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Produto com id: " + id + " não encontrado"));
    }

    public ProdutoDTO cadastrar(ProdutoDTO produtoDTO) {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        produtoRepository.save(produto);
        return produtoDTO;
    }

    public ProdutoDTO editar(ProdutoDTO produtoDTO) {
        getById(produtoDTO.getId());
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        produtoRepository.save(produto);
        return produtoDTO;
    }

    public void deletar(Long id) {
        Produto produto = getById(id);
        produtoRepository.delete(produto);
    }
}
