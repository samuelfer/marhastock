package com.marhasoft.marhastock.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntradaProdutoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime dataEntrada;
    private Double valorTotal;
    @Size(max = 20)
    private String numNotaFiscal;
    private Double valorImposto;

    private List<ItemEntradaDTO> itensEntrada = new ArrayList<>();
}
