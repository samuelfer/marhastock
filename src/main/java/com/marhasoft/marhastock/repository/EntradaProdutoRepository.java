package com.marhasoft.marhastock.repository;

import com.marhasoft.marhastock.model.EntradaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaProdutoRepository extends JpaRepository<EntradaProduto, Long> {
}
