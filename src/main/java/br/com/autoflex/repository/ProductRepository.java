package br.com.autoflex.repository;

import java.util.UUID;

import br.com.autoflex.entity.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.Dependent;

@Dependent
public class ProductRepository implements PanacheRepositoryBase<Product, UUID> {

}
