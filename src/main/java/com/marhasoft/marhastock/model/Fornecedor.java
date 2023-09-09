package com.marhasoft.marhastock.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank()
    @Size(min = 5, max = 255)
    private String nome;
    private String cnpj;
    @Email
    @Size(max = 150)
    private String email;
    @Size(max = 12)
    private String telefone;
    @Size(max = 12)
    private String celular;
    private String inscEstadual;
    @Size(max = 8)
    private String cep;
    @Size(max = 255)
    private String estado;
    @Size(max = 255)
    private String cidade;
    @Size(max = 255)
    private String rua;
    @Size(max = 255)
    private String bairro;
    @Size(max = 5)
    private String numero;
}
