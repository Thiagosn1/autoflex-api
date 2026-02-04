package br.com.autoflex.repository;

import java.util.UUID;

import br.com.autoflex.entity.RawMaterial;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.Dependent;

@Dependent
public class RawMaterialRepository implements PanacheRepositoryBase<RawMaterial, UUID> {

}
