package com.prueba.myecommerce.controllers;

import com.prueba.myecommerce.entities.Product;
import com.prueba.myecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping(path = "/index")
public class ControllerProduct {

    @Autowired
    private ProductService SvcProduct;

    @GetMapping("/products")
    public String ShowProducts(Model model) {

        try {
            List<Product> products = this.SvcProduct.findAll();
            model.addAttribute("products", products);
            return "/products";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("products/create")
    public String CreateProduct(Model model, @PathVariable("id") long id) {
        try {
            if (id == 0) {
                model.addAttribute("products", new Product());
            } else {
                model.addAttribute("products", this.SvcProduct.findById(id));
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
        return "/index";
    }

    @PostMapping("products/update")
    public String UpdateProduct(@ModelAttribute("products") Product product, Model model, @PathVariable("id") long id)
    {
        try {
            if (id == 0) {
                this.SvcProduct.saveOne(product);
            } else {
                this.SvcProduct.updateOne(product, id);
            }
            return "redirect:/index";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }


   }
    @GetMapping("/products/{id}")
    public String DeleteProduct(Model model, @PathVariable("id") long id) {

        try{
            this.SvcProduct.deleteById(id);
            return "/products";
        }
            catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }




}
