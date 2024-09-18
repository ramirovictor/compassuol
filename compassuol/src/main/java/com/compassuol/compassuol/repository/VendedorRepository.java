package com.compassuol.compassuol.repository;

import com.compassuol.compassuol.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    Optional<Vendedor> findByCodigo(String codigo);
}

