package com.marhasoft.marhastock.model;

import jakarta.persistence.*;
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
@Entity
@Table(name = "itens_saida")
public class ItemSaida {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
}
