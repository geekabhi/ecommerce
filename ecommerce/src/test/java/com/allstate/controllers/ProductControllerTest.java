package com.allstate.controllers;

import com.allstate.entities.Product;
import com.allstate.services.ProductService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService service;

    @Before
    public void setUp() throws Exception {


    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateProduct() throws Exception {

        Product product = new Product();
        product.setId(2);
        product.setName("Google");
        product.setStock("12326");
        product.setList_price(1000.00);
        product.setDiscount(0.50);

        given(this.service.create(Mockito.any(Product.class)))
                .willReturn(product);

        MockHttpServletRequestBuilder request = post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"blahblah\", \"stock\": \"45678\"}");

        this.mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",is(2)))
                .andExpect(jsonPath("$.name",is("Google")));
    }

    @Test
    public void shouldFindProductById() throws Exception {

        Product product = new Product();
        product.setId(2);
        product.setName("Google");
        product.setStock("12326");
        product.setList_price(1000.00);
        product.setDiscount(0.50);

        given(this.service.findById(2))
                .willReturn(product);

        MockHttpServletRequestBuilder request = get("/products/2")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",is(2)))
                .andExpect(jsonPath("$.name",is("Google")));
    }

}