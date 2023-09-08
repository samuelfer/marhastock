package com.marhasoft.marhastock.repository;

import com.marhasoft.marhastock.model.SaidaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaidaProdutoRepository extends JpaRepository<SaidaProduto, Long> {
}
