package com.allstate.services;

import com.allstate.entities.Product;
import com.allstate.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {


    private IProductRepository repository;

    // Autowired Generate the class and send the repository object.
    // JPA knows that instead of interface, spring needs the class.
    @Autowired
    public void setRepository(IProductRepository repository) {
        this.repository = repository;
    }

    public Product create(Product product) {

        return  this.repository.save(product);
    }

    public Product findById(int id){
        return this.repository.findOne(id);
    }


    public Iterable<Product> findAll() {
        return this.repository.findAll();
    }

    public Product findByName(String name) {
        return this.repository.findByName(name);
    }

    public Product findByStock(String stock) {
        return this.repository.findByStock(stock);
    }

    public void delete(int id) {
        this.repository.delete(id);
    }

    public Product update(int id, Product product) {
        Product foundProduct = this.findById(id);

        foundProduct.setName(product.getName());
        foundProduct.setStock(product.getStock());
        foundProduct.setDescription(product.getDescription());
        foundProduct.setRating(product.getRating());
        foundProduct.setReviews_count(product.getReviews_count());
        foundProduct.setList_price(product.getList_price());
        foundProduct.setDiscount(product.getDiscount());
        foundProduct.setQuantity(product.getQuantity());
        foundProduct.setRestricted(product.isRestricted());

        return this.repository.save(foundProduct);
    }
}
