package com.marhasoft.marhastock.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private final int status;
    private final String mensagem;
    private String stackTrace;
    private List<ValidationError> erros;

    @Data
    @RequiredArgsConstructor
    private static class ValidationError {
        private final String campo;
        private final String mensagem;
    }

    public void addValidationError(String campo, String mensagem) {
        if (Objects.isNull(erros)) {
            this.erros = new ArrayList<>();
        }
        this.erros.add(new ValidationError(campo, mensagem));
    }

}
