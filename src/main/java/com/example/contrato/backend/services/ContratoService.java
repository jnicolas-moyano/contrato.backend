package com.example.contrato.backend.services;

import com.example.contrato.backend.DTOs.ContratoDTO;
import com.example.contrato.backend.entities.Contrato;
import com.example.contrato.backend.repository.ContratoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ContratoDTO createContrato(ContratoDTO contratoDto) {
        Contrato contrato = modelMapper.map(contratoDto, Contrato.class);
        Contrato savedContrato = contratoRepository.save(contrato);
        return modelMapper.map(savedContrato, ContratoDTO.class);
    }

    public List<ContratoDTO> getAllContratos() {
        return contratoRepository.findAll().stream()
                .map(contrato -> modelMapper.map(contrato, ContratoDTO.class))
                .collect(Collectors.toList());
    }

    public ContratoDTO getContratoById(Long id) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
        return modelMapper.map(contrato, ContratoDTO.class);
    }

    public ContratoDTO updateContrato(Long id, ContratoDTO contratoDto) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));

        contrato.setIdentificador(contratoDto.getIdentificador());
        contrato.setValor(contratoDto.getValor());
        contrato.setNombreContratante(contratoDto.getNombreContratante());
        contrato.setDocumentoContratante(contratoDto.getDocumentoContratante());
        contrato.setNombreContratista(contratoDto.getNombreContratista());
        contrato.setDocumentoContratista(contratoDto.getDocumentoContratista());
        contrato.setFechaInicial(contratoDto.getFechaInicial());
        contrato.setFechaFinal(contratoDto.getFechaFinal());

        Contrato updatedContrato = contratoRepository.save(contrato);
        return modelMapper.map(updatedContrato, ContratoDTO.class);
    }

    public void deleteContrato(Long id) {
        contratoRepository.deleteById(id);
    }
}