package com.marhasoft.marhastock.dto;

import com.marhasoft.marhastock.model.Cliente;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaidaProdutoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime dataSaida;
    private Double valorTotal;
    private Cliente cliente;
}
