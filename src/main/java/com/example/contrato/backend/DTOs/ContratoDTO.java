package com.example.contrato.backend.DTOs;

import lombok.Data;
import java.util.Date;

@Data
public class ContratoDTO {
    private Long id;
    private String identificador;
    private Double valor;
    private String nombreContratante;
    private String documentoContratante;
    private String nombreContratista;
    private String documentoContratista;
    private Date fechaInicial;
    private Date fechaFinal;
}