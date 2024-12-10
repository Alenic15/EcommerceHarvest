package com.code.ecommerceharvest.backend.infrastructure.adapter;

import com.code.ecommerceharvest.backend.domain.model.Category;
import com.code.ecommerceharvest.backend.domain.port.ICategoryRepository;
import com.code.ecommerceharvest.backend.infrastructure.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;

@Repository

public class CategoryCrudRepositoryImpl implements ICategoryRepository {

    private final ICategoryCrudRepository iCategoryCrudRepository;
    private final CategoryMapper categoryMapper;

    public CategoryCrudRepositoryImpl(ICategoryCrudRepository iCategoryCrudRepository, CategoryMapper categoryMapper) {
        this.iCategoryCrudRepository = iCategoryCrudRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Category save(Category category) {
        return categoryMapper.toCategory(iCategoryCrudRepository.save(categoryMapper.toCategoryEntity(category))) ;
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryMapper.toCategoryList(iCategoryCrudRepository.findAll());
    }

    @Override
    public Category findById(Integer id) {
        return categoryMapper.toCategory(iCategoryCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Categoría con id: "+ id + " no existe")
        ));
    }

    @Override
    public void deleteById(Integer id) {
        iCategoryCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Categoría con id: "+ id + " no existe")
        );
        iCategoryCrudRepository.deleteById(id);
    }
}