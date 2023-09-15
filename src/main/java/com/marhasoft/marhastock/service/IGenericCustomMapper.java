package com.marhasoft.marhastock.service;

public interface IGenericCustomMapper {

    <T> T modelToDTO(Object origem, Class<T> destino);
}
