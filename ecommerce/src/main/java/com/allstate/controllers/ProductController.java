package com.allstate.controllers;

import com.allstate.entities.Product;
import com.allstate.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping(value = "/products")
@RestController
public class ProductController {

    // Injection is done with below service and setter
    private ProductService service;

    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    @RequestMapping(value = {"","/"}, method = RequestMethod.POST)
    public Product create(@RequestBody Product product) {
        return this.service.create(product);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public Product findById(@PathVariable int id) {
        return this.service.findById(id);
    }

    @RequestMapping(value = {"","/"}, method = RequestMethod.GET)
    public Iterable<Product> findAll() {
        return this.service.findAll();
    }

    @RequestMapping(value = {"/search/name"}, method = RequestMethod.GET)
    public Product findByName(@RequestParam Map<String,String> query) {
        return this.service.findByName(query.get("name"));
    }

    @RequestMapping(value = {"/search/stock"}, method = RequestMethod.GET)
    public Product findByStock(@RequestParam Map<String,String> query) {
        return this.service.findByStock(query.get("stock"));
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        this.service.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Product update(@PathVariable int id, @RequestBody Product product){
        return this.service.update(id, product);
    }
}
