package br.com.autoflex.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductResponseDTO {

    private UUID id;
    private String code;
    private String name;
    private BigDecimal price;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(UUID id, String code, String name, BigDecimal price) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
