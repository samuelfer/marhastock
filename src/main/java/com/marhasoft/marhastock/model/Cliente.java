package com.marhasoft.marhastock.model;

import com.marhasoft.marhastock.dto.ClienteDTO;
import jakarta.persistence.*;
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
@Entity
@Table(name = "fornecedor")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    public Cliente clienteDtoToCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getCnpf(),
                clienteDTO.getEmail(), clienteDTO.getTelefone(), clienteDTO.getCelular(),
                clienteDTO.getInscEstadual(), clienteDTO.getCep(), clienteDTO.getEstado(),
                clienteDTO.getCidade(), clienteDTO.getRua(), clienteDTO.getBairro(),
                clienteDTO.getNumero());
        return cliente;
    }
}
