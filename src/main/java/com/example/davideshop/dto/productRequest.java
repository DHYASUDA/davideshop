package com.example.davideshop.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class productRequest {
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer stockQuantity;

    private String category;

    private String createdBy;
    private String imageBase64;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public String getimageBase64() {
        return imageBase64;
    }

    public void setimageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
