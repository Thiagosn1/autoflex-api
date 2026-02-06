package br.com.autoflex.repository;

import java.util.List;
import java.util.UUID;

import br.com.autoflex.entity.ProductRawMaterial;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.Dependent;

@Dependent
public class ProductRawMaterialRepository implements PanacheRepositoryBase<ProductRawMaterial, UUID> {

    public List<ProductRawMaterial> findByProductId(UUID productId) {
        return find("product.id", productId).list();
    }

    public List<ProductRawMaterial> findByRawMaterialId(UUID rawMaterialId) {
        return find("rawMaterial.id", rawMaterialId).list();
    }

    public ProductRawMaterial findByProductAndRawMaterial(UUID productId, UUID rawMaterialId) {
        return find("product.id = ?1 and rawMaterial.id = ?2", productId, rawMaterialId).firstResult();
    }
}
