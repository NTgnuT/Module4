package com.example.modal.service.category;

import com.example.modal.dao.category.CategoryDAO;
import com.example.modal.dao.category.CategoryDAO_IMPL;
import com.example.modal.entity.Category;

import java.util.List;

public class CategoryServiceIMPL implements CategoryService {
    private final CategoryDAO categoryDAO = new CategoryDAO_IMPL();

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public boolean save(Category category) {
        return categoryDAO.save(category);
    }

    @Override
    public Category findById(Integer integer) {
        return categoryDAO.findById(integer);
    }

    @Override
    public void delete(Integer integer) {
        categoryDAO.delete(integer);
    }
}
