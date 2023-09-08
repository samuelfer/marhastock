package com.marhasoft.marhastock.dto;

import com.marhasoft.marhastock.model.EntradaProduto;
import com.marhasoft.marhastock.model.SaidaProduto;
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
public class ItemSaidaDTO {

    private Long id;
    @NotNull
    @Size(min = 1)
    private Double quantidade;
    @NotNull
    @Size(min = 1)
    private Double valorVenda;
    @NotNull
    @Size(min = 1)
    private Double valorTotal;
    @OneToOne
    @JoinColumn(name = "saida_id")
    private SaidaProduto codSaida;
}
