package it.polito.ai.prodotti.controllers;

import it.polito.ai.prodotti.dtos.IngredientDTO;
import it.polito.ai.prodotti.dtos.ProductDTO;
import it.polito.ai.prodotti.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<ProductDTO> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProduct(@PathVariable("id") String id) {
        try {
            return productService.getProduct(id);
        } catch (Exception e) {
//            e.printStack Trace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found (my)");
        }
    }

    @GetMapping("/products/{id}/ingredients")
    public List<IngredientDTO> getIngredients(@PathVariable("id") String id) {
        try {
            return productService.getIngredients(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found (my)");
        }
    }

    @GetMapping("/products_with/{id}")
    private List<ProductDTO> getProductContaining(@PathVariable("id") String id) {
        try {
            return productService.getProductsByIngredient(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found (my)");
        }
    }
}
