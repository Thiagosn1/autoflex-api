package br.com.autoflex.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.autoflex.dto.mapper.RawMaterialMapper;
import br.com.autoflex.dto.request.RawMaterialRequestDTO;
import br.com.autoflex.dto.response.RawMaterialResponseDTO;
import br.com.autoflex.entity.RawMaterial;
import br.com.autoflex.exception.ObjectNotFoundException;
import br.com.autoflex.repository.RawMaterialRepository;
import jakarta.enterprise.context.Dependent;
import jakarta.transaction.Transactional;

@Dependent
public class RawMaterialService {
    RawMaterialRepository rawMaterialRepository;
    RawMaterialMapper rawMaterialMapper;

    public RawMaterialService(RawMaterialRepository rawMaterialRepository, RawMaterialMapper rawMaterialMapper) {
        this.rawMaterialRepository = rawMaterialRepository;
        this.rawMaterialMapper = rawMaterialMapper;
    }

    @Transactional
    public RawMaterialResponseDTO newRawMaterial(RawMaterialRequestDTO dto) {
        RawMaterial rawMaterial = rawMaterialMapper.toEntity(dto);
        rawMaterialRepository.persist(rawMaterial);
        return rawMaterialMapper.toResponseDTO(rawMaterial);
    }

    public List<RawMaterialResponseDTO> listRawMaterials(Integer pageNumber, Integer pageSize) {
        return rawMaterialRepository.findAll()
                .page(pageNumber, pageSize)
                .list()
                .stream()
                .map(rawMaterialMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public RawMaterialResponseDTO listRawMaterial(UUID rawMaterialId) {
        RawMaterial rawMaterial = rawMaterialRepository.findByIdOptional(rawMaterialId)
                .orElseThrow(ObjectNotFoundException::new);
        return rawMaterialMapper.toResponseDTO(rawMaterial);
    }

    @Transactional
    public RawMaterialResponseDTO updateRawMaterial(UUID rawMaterialId, RawMaterialRequestDTO dto) {
        RawMaterial rawMaterial = rawMaterialRepository.findByIdOptional(rawMaterialId)
                .orElseThrow(ObjectNotFoundException::new);
        rawMaterialMapper.updateEntity(rawMaterial, dto);
        return rawMaterialMapper.toResponseDTO(rawMaterial);
    }

    @Transactional
    public void deleteRawMaterial(UUID rawMaterialId) {
        RawMaterial rawMaterial = rawMaterialRepository.findByIdOptional(rawMaterialId)
                .orElseThrow(ObjectNotFoundException::new);
        rawMaterialRepository.delete(rawMaterial);
    }
}