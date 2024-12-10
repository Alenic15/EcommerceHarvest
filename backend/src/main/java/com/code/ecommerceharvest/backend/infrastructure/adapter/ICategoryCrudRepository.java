package com.code.ecommerceharvest.backend.infrastructure.adapter;

import com.code.ecommerceharvest.backend.infrastructure.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryCrudRepository extends CrudRepository<CategoryEntity, Integer> {
}