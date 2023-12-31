package com.marhasoft.marhastock.model;

import jakarta.persistence.*;
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
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    @Size(min = 5, max = 255)
    private String descricao;
    @Size(max = 10)
    private String codigo;
    @ManyToOne
    @JoinColumn(name="categoria_id", nullable=false)
    private Categoria categoria;
    private Double peso;
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
    private int quantidadeMinima;
    private Double quantidadeEstoque;

    public void adicionarEstoque(Double quantidade) {
        this.quantidadeEstoque = this.quantidadeEstoque + quantidade;
    }

    public void retirarEstoque(Double quantidade) {
        this.quantidadeEstoque = this.quantidadeEstoque - quantidade;
    }
}
