package com.marhasoft.marhastock.dto;

import com.marhasoft.marhastock.model.EntradaProduto;
import com.marhasoft.marhastock.model.Produto;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemEntradaDTO {

    private Long id;
    @NotNull
    private Produto produto;
    @NotNull
    private Double quantidade;
    @NotNull
    private Double valorCompra;
    @NotNull
    private Double valorTotal;
    @OneToOne
    @JoinColumn(name = "entrada_id")
    private EntradaProduto codEntrada;
    private Double desconto;
}
