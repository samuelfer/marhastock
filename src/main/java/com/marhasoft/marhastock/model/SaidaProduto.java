package com.marhasoft.marhastock.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "saida_produto")
public class SaidaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime dataSaida;
    private Double valorTotal;
    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
