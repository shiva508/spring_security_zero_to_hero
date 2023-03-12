package com.pool.service;

import java.util.List;

import com.pool.form.ProductForm;
import com.pool.model.Product;

public interface ProductService {
public ProductForm saveProduct(ProductForm productForm);
public List<Product> products();
public ProductForm product(Integer productId);

}
