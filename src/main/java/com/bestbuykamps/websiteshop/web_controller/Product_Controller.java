package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.business_service.ProductService;
import com.bestbuykamps.websiteshop.data_model.Product;
import com.bestbuykamps.websiteshop.data_model.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/products")
public class Product_Controller {

    private final ProductService productService;

    public Product_Controller(ProductService productService) {
        this.productService = productService;

    }

    @RequestMapping(method = RequestMethod.GET)
    public String getProducts(Model model){
        model.addAttribute("products", this.productService.getProducts());
        return "productList";
    }

}
