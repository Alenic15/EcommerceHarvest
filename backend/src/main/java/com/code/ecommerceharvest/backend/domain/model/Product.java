package com.code.ecommerceharvest.backend.domain.model;

import com.code.ecommerceharvest.backend.infrastructure.entity.CategoryEntity;
import com.code.ecommerceharvest.backend.infrastructure.entity.UserEntity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    private Integer id;
    private String name;
    private String code;
    private String description;
    private String urlImage;
    private BigDecimal price;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private Integer userId;
    private Integer categoryId;

}
