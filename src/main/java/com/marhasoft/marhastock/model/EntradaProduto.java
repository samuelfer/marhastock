package com.marhasoft.marhastock.model;

import jakarta.persistence.*;
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
@Entity
@Table(name = "entrada_produto")
public class EntradaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime dataEntrada;
    private Double valorTotal;
    @Size(max = 20)
    private String numNotaFiscal;
    private Double valorImposto;

    @OneToMany
    @JoinColumn(name = "entrada_id", referencedColumnName = "id")
    private List<ItemEntrada> itensEntrada = new ArrayList<>();
}
