package com.example.demo.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Category;
import com.example.demo.model.repo.CategoryRepo;
import com.example.demo.model.service.CategoryService;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category addCategory(Category category) {
       
      return   categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
       return categoryRepo.save(category);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategory(Long categoryId) {
       return categoryRepo.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        
        Category category = new Category();
        category.setCid(categoryId);
        categoryRepo.deleteById(categoryId);

    }
    
}
