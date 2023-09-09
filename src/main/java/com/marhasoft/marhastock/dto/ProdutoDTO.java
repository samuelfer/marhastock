package com.marhasoft.marhastock.dto;

import com.marhasoft.marhastock.model.Categoria;
import com.marhasoft.marhastock.model.Fornecedor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoDTO {

    private Long id;
    @NotBlank
    @Size(min = 5, max = 255)
    private String descricao;
    @Size(max = 10)
    private String codigo;
    @NotNull
    private Categoria categoria;
    private Double peso;
    @NotNull
    private Fornecedor fornecedor;
    private int quantidadeMinima;
    private Double quantidadeEstoque;
}
