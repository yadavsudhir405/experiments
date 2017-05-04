package github.com.yadavsudhir405.springwebsecurity.controller;

import github.com.yadavsudhir405.springwebsecurity.domain.Product;
import github.com.yadavsudhir405.springwebsecurity.domain.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sudhir
 *         Date:3/5/17
 *         Time:4:45 PM
 *         Project:spring-web-security
 */
@RestController
@RequestMapping(path = "/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        System.out.println("Inside Product controller");
       return productRepository.save(product);
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
