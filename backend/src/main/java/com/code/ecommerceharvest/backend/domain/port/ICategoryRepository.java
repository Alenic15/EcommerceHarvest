package com.code.ecommerceharvest.backend.domain.port;

import com.code.ecommerceharvest.backend.domain.model.Category;

public interface ICategoryRepository {
    Category save (Category category);
    Iterable<Category> findAll();
    Category findById(Integer id);
    void deleteById(Integer id);

}