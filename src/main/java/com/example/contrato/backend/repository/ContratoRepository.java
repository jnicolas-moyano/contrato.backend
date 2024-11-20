package com.example.contrato.backend.repository;

import com.example.contrato.backend.entities.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}
