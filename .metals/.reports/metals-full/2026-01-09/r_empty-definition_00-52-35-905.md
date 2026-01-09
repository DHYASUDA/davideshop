error id: file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/controller/productController.java:java/lang/Long#
file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/controller/productController.java
empty definition using pc, found symbol in pc: java/lang/Long#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 2230
uri: file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/controller/productController.java
text:
```scala
package com.example.davideshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.davideshop.dto.productRequest;
import com.example.davideshop.dto.productUpdateRequest;
import com.example.davideshop.model.productEntity;
import com.example.davideshop.service.productService;


@RestController // tells java that this class is a restcontroller and to look for http requests
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class productController {
    private final productService productService;

    public productController(productService productService) {
        this.productService = productService;
    }

    @PostMapping("/createProduct")
    public ResponseEntity<productEntity> createProduct(@RequestBody productRequest request){
        productEntity product = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    @PostMapping("/search-by-id")
    public productEntity searchById(@RequestBody productRequest request) {// this turns react json file to a dto
        return productService.searchById(request);
    }

    @PostMapping("/display-user-products")
    public ResponseEntity<List<productEntity>> displayUserProducts(@RequestBody productRequest request){
    List<productEntity> products = productService.searchByEmail(request.getCreatedBy());

    // Return the list with a 200 OK status
    return ResponseEntity.ok(products);
    }
    @GetMapping("/{id}") //path variable gets the id from the url
    public ResponseEntity<productEntity> getById(@PathVariable("id") Lo@@ng id){
        productEntity product = productService.searchByIdLong(id);
    return ResponseEntity.ok(product);
    }

    @PutMapping(
    value = "/{id}",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
)
public ResponseEntity<productEntity> updateProduct(
        @PathVariable("id") Long id,
        @RequestBody productUpdateRequest request
) {
    productEntity updated = productService.updateProductInfo(id, request);
    return ResponseEntity.ok(updated);
}

}


 
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/Long#