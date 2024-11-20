package com.example.contrato.backend.controller;

import com.example.contrato.backend.DTOs.ContratoDTO;
import com.example.contrato.backend.services.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @PostMapping
    public ContratoDTO createContrato(@RequestBody ContratoDTO contratoDto) {
        return contratoService.createContrato(contratoDto);
    }

    @GetMapping
    public List<ContratoDTO> getAllContratos() {
        return contratoService.getAllContratos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoDTO> getContratoById(@PathVariable Long id) {
        return ResponseEntity.ok(contratoService.getContratoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoDTO> updateContrato(@PathVariable Long id, @RequestBody ContratoDTO contratoDto) {
        return ResponseEntity.ok(contratoService.updateContrato(id, contratoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContrato(@PathVariable Long id) {
        contratoService.deleteContrato(id);
        return ResponseEntity.noContent().build();
    }
}