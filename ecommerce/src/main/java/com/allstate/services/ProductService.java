package com.allstate.services;

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


}
