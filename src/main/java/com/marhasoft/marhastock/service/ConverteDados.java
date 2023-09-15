package com.marhasoft.marhastock.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ConverteDados implements IGenericCustomMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public <T> T modelToDTO(Object origem, Class<T> destino) {
        if (origem == null) {
            return null;
        }
        T resultado = modelMapper.map(origem, destino);
        return resultado;
    }
}
