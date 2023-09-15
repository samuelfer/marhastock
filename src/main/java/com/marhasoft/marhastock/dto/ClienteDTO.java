package com.marhasoft.marhastock.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {

    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 255)
    @Column(length = 255, nullable = false)
    private String nome;

    @CNPJ
    private String cnpf;

    @Email
    @Length(max = 120)
    private String email;

    @Length(max = 12)
    private String telefone;

    @Length(max = 12)
    private String celular;

    @Length(max = 20)
    private String inscEstadual;

    @Length(max = 8)
    private String cep;

    @Length(max = 20)
    private String estado;

    @Length(max = 100)
    private String cidade;

    @Length(max = 255)
    private String rua;

    @Length(max = 255)
    private String bairro;

    @Length(max = 5)
    private String numero;
}
