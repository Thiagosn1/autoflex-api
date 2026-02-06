package br.com.autoflex.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public class RawMaterialResponseDTO {
    private UUID id;
    private String code;
    private String name;
    private BigDecimal quantityInStock;

    public RawMaterialResponseDTO() {
    }

    public RawMaterialResponseDTO(UUID id, String code, String name, BigDecimal quantityInStock) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantityInStock = quantityInStock;
    }

    public UUID getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(BigDecimal quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
