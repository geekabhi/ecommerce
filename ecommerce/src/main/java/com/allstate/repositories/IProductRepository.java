package com.allstate.repositories;


import com.allstate.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository  extends CrudRepository<Product,Integer>{
    Product findByName(String name);
    Product findByStock(String name);
}
