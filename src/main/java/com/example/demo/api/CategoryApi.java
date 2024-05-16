package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entity.Category;
import com.example.demo.model.service.CategoryService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/category")
public class CategoryApi {
    
    @Autowired
    private CategoryService categoryService;

    //add category
    @PostMapping("/")
    public ResponseEntity<?> addCategory(@RequestBody Category categories) {
        Category category = categoryService.addCategory(categories);
        return ResponseEntity.ok(category);
    }

    //get category
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId) {
        return categoryService.getCategory(categoryId);
    }

    // get all categories 
    @GetMapping("/")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    //update category
    @PutMapping("/")
    public Category updateCategory( @RequestBody Category category) {
        
        
        return categoryService.updateCategory(category);
    }

    //delete category
    @DeleteMapping("/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
        return "Category has been successfully deleted";
    }
    
    
    
}
