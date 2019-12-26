package com.button.web.controller;

import com.button.model.entity.ProductList;
import com.button.model.repo.ProductListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/", "index"})
public class IndexController {
    @Autowired
    ProductListRepository productListRepository;

    @GetMapping
    public String index(Model model) {
        Iterable<ProductList> productLists;

        productLists = productListRepository.findAll();
        model.addAttribute("productLists", productLists);

        return "index";
    }
}
