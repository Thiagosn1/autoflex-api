package br.com.autoflex.service;

import java.util.List;
import java.util.UUID;

import br.com.autoflex.entity.RawMaterial;
import br.com.autoflex.exception.ObjectNotFoundException;
import br.com.autoflex.repository.RawMaterialRepository;
import jakarta.enterprise.context.Dependent;
import jakarta.transaction.Transactional;

@Dependent
public class RawMaterialService {
    RawMaterialRepository rawMaterialRepository;

    public RawMaterialService(RawMaterialRepository rawMaterialRepository) {
        this.rawMaterialRepository = rawMaterialRepository;
    }

    @Transactional
    public RawMaterial newRawMaterial(RawMaterial rawMaterial) {
        rawMaterialRepository.persist(rawMaterial);
        return rawMaterial;
    }

    public List<RawMaterial> listRawMaterials(Integer pageNumber, Integer pageSize) {
        return rawMaterialRepository.findAll().page(pageNumber, pageSize).list();
    }

    public RawMaterial listRawMaterial(UUID rawMaterialId) {
        return rawMaterialRepository.findByIdOptional(rawMaterialId).orElseThrow(ObjectNotFoundException::new);
    }

    @Transactional
    public RawMaterial updateRawMaterial(UUID rawMaterialId, RawMaterial rawMaterial) {
        RawMaterial currentRawMaterial = listRawMaterial(rawMaterialId);
        currentRawMaterial.setCode(rawMaterial.getCode());
        currentRawMaterial.setName(rawMaterial.getName());
        currentRawMaterial.setQuantityInStock(rawMaterial.getQuantityInStock());
        return currentRawMaterial;
    }

    @Transactional
    public void deleteRawMaterial(UUID rawMaterialId) {
        RawMaterial rawMaterial = listRawMaterial(rawMaterialId);
        rawMaterialRepository.delete(rawMaterial);
    }

}