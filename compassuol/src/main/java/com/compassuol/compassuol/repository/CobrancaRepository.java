package com.compassuol.compassuol.repository;

import com.compassuol.compassuol.model.Cobranca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CobrancaRepository extends JpaRepository<Cobranca, Long> {
    Optional<Cobranca> findByCodigo(String codigo);
}
