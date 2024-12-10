package com.code.ecommerceharvest.backend.infrastructure.adapter;

import com.code.ecommerceharvest.backend.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface IProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
}
