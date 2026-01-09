error id: file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/service/productService.java:_empty_/productEntity#
file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/service/productService.java
empty definition using pc, found symbol in pc: _empty_/productEntity#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 971
uri: file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/service/productService.java
text:
```scala
package com.example.davideshop.service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.davideshop.dto.productRequest;
import com.example.davideshop.dto.userUpdateRequest;
import com.example.davideshop.dto.productUpdateRequest;
import com.example.davideshop.model.productEntity;
import com.example.davideshop.repository.productRepo;

@Service
public class productService {
    private final productRepo productRepo;

    public productService(productRepo productRepo) {
        this.productRepo = productRepo;
    }

    // create product
    public @@productEntity updateProductInfo (@RequestBody productUpdateRequest req, Long id){
        productEntity p = productRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found"));

    if (req.getPrice() != null) p.setPrice(req.getPrice());
    if (req.getDescription() != null) p.setDescription(req.getDescription());
    if (req.getCategory() != null) p.setCategory(req.getCategory());
    if (req.getStockQuantity() != null) p.setStockQuantity(req.getStockQuantity());
    if (req.getName() != null) p.setName(req.getName());

    return productRepo.save(p);
    }
    public productEntity createProduct(productRequest request) {
        productEntity product = new productEntity();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStockQuantity(request.getStockQuantity());
        product.setCategory(request.getCategory());
        product.setCreatedBy(request.getCreatedBy());

        String dataUrl = request.getImageBase64(); // make sure DTO getter name matches
 
        if (dataUrl != null && !dataUrl.isBlank()) {
            int comma = dataUrl.indexOf(',');
            if (comma < 0) throw new IllegalArgumentException("Invalid imageBase64 format");

            String meta = dataUrl.substring(0, comma);
            String b64 = dataUrl.substring(comma + 1);

            String ext = "jpg";
            if (meta.contains("image/png")) ext = "png";
            else if (meta.contains("image/webp")) ext = "webp";
            else if (meta.contains("image/jpeg")) ext = "jpg";

            byte[] bytes = Base64.getDecoder().decode(b64);

            if (bytes.length > 2 * 1024 * 1024) {
                throw new IllegalArgumentException("Image too large (max 2MB)");
            }

            try {
                Files.createDirectories(Paths.get("uploads"));
                String filename = UUID.randomUUID() + "." + ext;
                Path path = Paths.get("uploads").resolve(filename);
                Files.write(path, bytes, StandardOpenOption.CREATE_NEW);

                product.setImageUrl("/uploads/" + filename);
            } catch (IOException e) {
                throw new RuntimeException("Failed to save uploaded image", e);
            }
        }

        return productRepo.save(product);
    }
    // search product by id
    public productEntity searchById(productRequest request) {
        Optional<productEntity> optionalProduct = productRepo.findById(request.getId());

        if (optionalProduct.isEmpty()) {
            throw new IllegalArgumentException("Unable to find product");
        }
        productEntity product = optionalProduct.get();
        return product;
    }
    //search product by email from the created_by
    public List<productEntity> searchByEmail(String email){
        //this gets email
        List<productEntity> optionalProduct = productRepo.findByCreatedBy(email);
        if(optionalProduct.isEmpty()){
            throw new IllegalArgumentException("Unable to find products from email");
        }
        return optionalProduct;
    }

    public productEntity searchByIdLong(Long id) {
    return productRepo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Unable to find product"));
}

}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/productEntity#