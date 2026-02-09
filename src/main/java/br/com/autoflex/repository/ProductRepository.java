package br.com.autoflex.repository;

import java.util.List;
import java.util.UUID;

import br.com.autoflex.entity.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.Dependent;

@Dependent
public class ProductRepository implements PanacheRepositoryBase<Product, UUID> {

    public List<Product> findAllOrderedByPriceDesc() {
        return find("ORDER BY price DESC").list();
    }

    public List<Product> findProductsWithRawMaterials() {
        return find("SELECT DISTINCT p FROM Product p JOIN p.rawMaterials ORDER BY p.price DESC").list();
    }
}