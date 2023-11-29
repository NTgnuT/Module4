package com.example.modal.service.product;

import com.example.modal.dao.product.ProductDAO;
import com.example.modal.dao.product.ProductDAO_IMPL;
import com.example.modal.entity.Product;

import java.util.List;

public class ProductServiceIMPL implements ProductService{
    private final ProductDAO productDAO = new ProductDAO_IMPL();
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public boolean save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public Product findById(Integer integer) {
        return productDAO.findById(integer);
    }

    @Override
    public void delete(Integer integer) {
        productDAO.delete(integer);
    }
}
