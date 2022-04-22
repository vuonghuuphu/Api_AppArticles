package com.example.javaspring.Api;

import com.example.javaspring.Product.Product;
import com.example.javaspring.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/V1/product")
public class ProductApi {

    @Autowired
    ProductRepository productRepository;

    private static List<Product> listproduct;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getlist() {
        return productRepository.findAll();
    }

    @PostMapping
    public boolean save(@RequestBody Product p) {
        if (p != null) {
            productRepository.save(p);
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Product detail(@PathVariable int id) {
        return productRepository.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public Product update(@PathVariable int id, @RequestBody Product p) {
        Product found = productRepository.findById(id).get();
        if (found != null) {
            found.setName(p.getName());
            found.setStatus(p.getStatus());
            found.setDescription(p.getDescription());
            found.setPrice(p.getPrice());
        }
        productRepository.save(found);
        return found;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public String delete(@PathVariable int id) {
           productRepository.delete(productRepository.findById(id).get());
        return "delete";
    }

}
