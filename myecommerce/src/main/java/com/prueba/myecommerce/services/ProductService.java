package com.prueba.myecommerce.services;


import com.prueba.myecommerce.entities.Product;
import com.prueba.myecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements BaseService<Product>{

    @Autowired
    private ProductRepository repository;

    @Transactional
    public List<Product> findAll() throws Exception {
        try {
            List<Product> entities = this.repository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Transactional
    public Product findById(long id) throws Exception {
        try {
            Optional<Product> opt = this.repository.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Transactional
    public Product saveOne(Product entity) throws Exception {
        try {
            Product producto = this.repository.save(entity);
            return producto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Product updateOne(Product entity, long id) throws Exception {
        try {
            Optional<Product> opt = this.repository.findById(id);
            Product producto = opt.get();
            producto = this.repository.save(entity);
            return producto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Product deleteById(long id) throws Exception {
            Optional<Product> opt = this.repository.findById(id);
            Product producto = opt.get();
            this.repository.deleteById(id);
            return opt.get();
    }

}

