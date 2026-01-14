error id: file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/seed/productSeeder.java:com/example/davideshop/seed/productSeeder#req#
file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/seed/productSeeder.java
empty definition using pc, found symbol in pc: com/example/davideshop/seed/productSeeder#req#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 1410
uri: file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/seed/productSeeder.java
text:
```scala
package com.example.davideshop.seed;
import java.math.BigDecimal;

//this populates product db with items to test.
//must be logged into dev
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.davideshop.dto.productRequest;
import com.example.davideshop.model.productEntity;
import com.example.davideshop.repository.productRepo;
import com.example.davideshop.service.productService;
// Imports your Spring Data repository, which provides DB operations like save(), findById(), delete(), count().
@Component
@Profile("dev")
public class productSeeder implements CommandLineRunner{

    //wire product service for the create product here
    private final productService productService;
    //this wires this class with the product repo class
    private final productRepo productRepo;
    productSeeder(productRepo productRepo, productService productService){
        this.productRepo = productRepo;
        this.productService = productService;
    }
    
    //this is what commandlinerunner needs in order to function
    @Override
    public void run(String... args) throws Exception {
        if(productRepo.count() > 0){return;}//if there is already items in the db, return (avoids dups)

        List<productEntity> products = List.of(
            @@req("Wireless Headphones", "Bluetooth noise-cancelling",
                 new BigDecimal("79.99"), 30, "ELECTRONICS",
                 "seed@davideshop.com", "/uploads/sample1.jpg")
        );


    }
     private productRequest req(String name, String description, BigDecimal price,
                               Integer stockQuantity, String category, String createdBy) {

        productRequest r = new productRequest();
        r.setName(name);
        r.setDescription(description);
        r.setPrice(price);
        r.setStockQuantity(stockQuantity);
        r.setCategory(category);
        r.setCreatedBy(createdBy);

        // For seeding, do NOT include images unless you want to embed base64 strings.
        r.setImageBase64(null);

        return r;
    }
    


}

```


#### Short summary: 

empty definition using pc, found symbol in pc: com/example/davideshop/seed/productSeeder#req#