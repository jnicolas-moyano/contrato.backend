package com.example.contrato.backend.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String identificador;

    private Double valor;
    private String nombreContratante;
    private String documentoContratante;
    private String nombreContratista;
    private String documentoContratista;

    @Temporal(TemporalType.DATE)
    private Date fechaInicial;

    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
}