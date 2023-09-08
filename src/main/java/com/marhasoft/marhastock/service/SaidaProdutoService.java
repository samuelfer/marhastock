package com.marhasoft.marhastock.service;

import com.marhasoft.marhastock.dto.SaidaProdutoDTO;
import com.marhasoft.marhastock.model.SaidaProduto;
import com.marhasoft.marhastock.repository.SaidaProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaidaProdutoService {

    @Autowired
    private SaidaProdutoRepository saidaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<SaidaProduto> getAll() {
        return saidaRepository.findAll();
    }

    public SaidaProduto getById(Long id) {
        return saidaRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Saída com id: " + id + " não encontrada"));
    }

    public SaidaProdutoDTO cadastrar(SaidaProdutoDTO saidaDTO) {
        SaidaProduto saidaProduto = modelMapper.map(saidaDTO, SaidaProduto.class);
        saidaRepository.save(saidaProduto);
        return saidaDTO;
    }

    public SaidaProdutoDTO editar(SaidaProdutoDTO saidaProdutoDTO) {
        getById(saidaProdutoDTO.getId());
        SaidaProduto saida = modelMapper.map(saidaProdutoDTO, SaidaProduto.class);
        saidaRepository.save(saida);
        return saidaProdutoDTO;
    }

    public void deletar(Long id) {
        SaidaProduto saida = getById(id);
        saidaRepository.delete(saida);
    }
}
