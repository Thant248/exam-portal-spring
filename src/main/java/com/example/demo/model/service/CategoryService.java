package com.example.demo.model.service;

import com.example.demo.model.entity.Category;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface CategoryService {
    

    public Category addCategory(Category category);

    public Category updateCategory(Category category);

    public List<Category> getCategories();

    public Category getCategory(Long categoryId);

    public void deleteCategory(Long categoryId);
}
