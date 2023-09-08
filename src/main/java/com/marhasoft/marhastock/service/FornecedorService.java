package com.marhasoft.marhastock.service;

import com.marhasoft.marhastock.dto.FornecedorDTO;
import com.marhasoft.marhastock.model.Fornecedor;
import com.marhasoft.marhastock.repository.FornecedorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Fornecedor> getAll() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor getById(Long id) {
        return fornecedorRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Fornecedor com id: " + id + " não encontrado"));
    }

    public FornecedorDTO cadastrar(FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = modelMapper.map(fornecedorDTO, Fornecedor.class);
        fornecedorRepository.save(fornecedor);
        return fornecedorDTO;
    }

    public FornecedorDTO editar(FornecedorDTO fornecedorDTO) {
        getById(fornecedorDTO.getId());
        Fornecedor fornecedor = modelMapper.map(fornecedorDTO, Fornecedor.class);
        fornecedorRepository.save(fornecedor);
        return fornecedorDTO;
    }

    public void deletar(Long id) {
        Fornecedor fornecedor = getById(id);
        fornecedorRepository.delete(fornecedor);
    }
}
