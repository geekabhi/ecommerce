package com.allstate.services;

import com.allstate.entities.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class ProductServiceTest {

    @Autowired
    private ProductService service;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateProductWithNameAndStock() throws Exception {

        Product expected = new Product();
        
        expected.setName("Google");
        expected.setStock("12326");
        expected.setList_price(1000.00);
        expected.setDiscount(0.50);
        
        Product actual = this.service.create(expected);

        assertTrue(actual.getId()>0);
        assertEquals(500,actual.getActual_price(),0.00);
        

    }

    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
    public void shouldCreateUniqueProductWithUniqueNameAndStock() throws Exception {

        Product expected = new Product();

        expected.setName("Microsoft");
        expected.setStock("12345");
        expected.setList_price(1000.00);
        expected.setDiscount(0.50);

        Product actual = service.create(expected);
    }

    @Test
    public void shouldReturnProduct() throws Exception {
        Product p  = this.service.findById(1);
        assertEquals(1, p.getId());

    }

    @Test
    public void shouldReturnAllProduct() throws Exception{
        Product product = new Product();

        product.setName("Microsoft");
        product.setStock("12346");

        service.create(product);

        ArrayList<Product> products = (ArrayList<Product>) this.service.findAll();

        assertEquals(2,products.size());
    }

    @Test
    public void shouldReturnProductByName() throws Exception{
        Product product = new Product();

        product.setName("Microsoft");
        product.setStock("12346");

        service.create(product);

        Product actual = this.service.findByName("Microsoft");

        assertEquals(product.getName(),actual.getName());
    }

    @Test
    public void shouldReturnDefaultProductByName() throws Exception{
        Product product = new Product();

        product.setName("Microsoft");
        product.setStock("12346");

        service.create(product);

        Product actual = this.service.findByName("Apple");

        assertEquals("Apple",actual.getName());
    }

    @Test
    public void shouldReturnNullProductByName() throws Exception{
        Product product = new Product();

        product.setName("Microsoft");
        product.setStock("12346");

        service.create(product);

        Product actual = this.service.findByName("XYZ");

        assertNull(actual);
    }

    @Test
    public void shouldReturnProductByStock() throws Exception{
        Product product = new Product();

        product.setName("Microsoft");
        product.setStock("12346");

        service.create(product);

        Product actual = this.service.findByStock("12345");

        assertEquals("Apple",actual.getName());
        assertEquals("12345",actual.getStock());
    }

    @Test
    public void shouldDeleteProductById() throws Exception{
        Product product = new Product();

        product.setName("Google");
        product.setStock("12346");

        service.create(product);

        this.service.delete(2);

        Product product1 = this.service.findById(2);

        assertNull(product1);
    }

    @Test
    public void shouldUpdateProductById() throws Exception{
        Product product = new Product();

        product.setName("Google");
        product.setStock("12346");
        product.setList_price(2000);
        product.setDiscount(0.10);

        Product updated = this.service.update(1,product);

        Product product1 = this.service.findById(1);

        assertEquals(1,updated.getVersion());
        assertEquals(updated.getName(),product1.getName());
        assertEquals(updated.getStock(),product1.getStock());
        assertEquals(1800.00,product1.getActual_price(),0.00);
    }

}