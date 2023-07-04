package pl.as.produkty;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller

public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/lista")

    public String list(@RequestParam(value = "kategoria", required = false) Category category, Model model) {
        if (category != null) {
            List<Product> products = productRepository.findByCategory(category);
            model.addAttribute("products", products);
            double sum = productRepository.getSumByCategory(category);
            model.addAttribute("category", "artykuly " + category.getDescription());
            model.addAttribute("products", products);
            model.addAttribute("priceSum", sum);
            return "list";
        } else {
            List<Product> products = productRepository.findAll();
            model.addAttribute("products", products);
            double sum = productRepository.getSumAll();
            model.addAttribute("category", "artykuly wszystkie");
            model.addAttribute("products", products);
            model.addAttribute("priceSum", sum);
            return "list";
            }
        }

    @PostMapping("/dodaj")
    public String add(@RequestParam String name, @RequestParam double price, @RequestParam Category category) {
        productRepository.add(new Product(name, price, category));

        return "redirect:/";
    }

    }


