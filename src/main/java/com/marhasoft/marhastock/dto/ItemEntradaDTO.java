package com.marhasoft.marhastock.dto;

import com.marhasoft.marhastock.model.EntradaProduto;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
public class ItemEntradaDTO {

    private Long id;
    @NotNull
    @Size(min = 1)
    private Double quantidade;
    @NotNull
    @Size(min = 1)
    private Double valorCompra;
    @NotNull
    @Size(min = 1)
    private Double valorTotal;
    @OneToOne
    @JoinColumn(name = "entrada_id")
    private EntradaProduto codEntrada;
    private Double desconto;
}
