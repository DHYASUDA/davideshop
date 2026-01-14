package com.example.davideshop.seed;
import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

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

        String createdBy = "seed@davideshop.com";
        String img = "/uploads/29d90ee8-eabe-4757-bcdd-aa116d31dd58.jpg";
            String[] categories = {"ELECTRONICS", "BOOKS", "CLOTHING", "HOME", "SPORTS", "OTHER"};

    String[] electronics = {"Bluetooth Speaker", "Wireless Mouse", "Mechanical Keyboard", "USB-C Hub", "Smart Watch", "Gaming Headset"};
    String[] books       = {"Java Fundamentals", "Spring Boot Guide", "SQL Workbook", "Data Structures", "System Design", "Clean Code Notes"};
    String[] clothing    = {"Hoodie", "T-Shirt", "Joggers", "Jacket", "Beanie", "Socks"};
    String[] home        = {"Coffee Mug", "Desk Lamp", "Throw Blanket", "Cutting Board", "Water Bottle", "Storage Bin"};
    String[] sports      = {"Jump Rope", "Wrist Wraps", "Resistance Bands", "Gym Towel", "Mouthguard", "Hand Grips"};

    java.util.ArrayList<productEntity> products = new java.util.ArrayList<>();

    // Seed 100 products
    for (int i = 1; i <= 100; i++) { 
        String category = categories[i % categories.length];//loops thru categories 1,2,3,4,5,0,1,2,3,4,5

        String name;
        switch (category) {
            case "ELECTRONICS" -> name = electronics[i % electronics.length] + " " + i;
            case "BOOKS"       -> name = books[i % books.length] + " " + i;
            case "CLOTHING"    -> name = clothing[i % clothing.length] + " " + i;
            case "HOME"        -> name = home[i % home.length] + " " + i;
            case "SPORTS"      -> name = sports[i % sports.length] + " " + i;
            default            -> name = "Item " + i;
        }

        String desc = "Seeded product #" + i + " in category " + category;

        // Price pattern: 9.99 to ~109.99
        BigDecimal price = new BigDecimal("9.99").add(new BigDecimal(i));

        // Stock pattern: 5 to 54
        int stock = 5 + (i % 50);

        products.add(make(name, desc, price, stock, category, createdBy, img));
    }

    productRepo.saveAll(products);
    System.out.println("Seeded " + products.size() + " products.");




    }
      private productEntity make(
            String name,
            String desc,
            BigDecimal price,
            int stock,
            String category,
            String createdBy,
            String imageUrl
    ) {
        // Helper method: builds a productEntity object in one place.
        // This keeps the run() method clean and avoids repeating field-setting code.

        productEntity p = new productEntity();
        // Creates a new entity object (not yet saved to DB).

        p.setName(name);
        // Sets the product name.

        p.setDescription(desc);
        // Sets the product description.

        p.setPrice(price);
        // Sets the price (using BigDecimal).

        p.setStockQuantity(stock);
        // Sets the stock quantity.

        p.setCategory(category);
        // Sets the category string (must match what your app expects).

        p.setCreatedBy(createdBy);
        // Sets who created the product (you use this for ownership checks in frontend).

        p.setImageUrl(imageUrl);
        // Sets the imageUrl path your frontend uses:
        // <img src={`http://localhost:8080${product.imageUrl}`} />

        return p;
        // Returns the filled-out productEntity object to be added into the list.
    }
    


}
