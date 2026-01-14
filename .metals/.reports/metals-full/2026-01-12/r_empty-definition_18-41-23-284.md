error id: file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/repository/productRepo.java:java/util/List#
file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/repository/productRepo.java
empty definition using pc, found symbol in pc: java/util/List#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 412
uri: file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/repository/productRepo.java
text:
```scala
package com.example.davideshop.repository;
import com.example.davideshop.model.productEntity;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
public interface productRepo extends JpaRepository<productEntity,Long> {
    //optional returns a singluar entity, while List returns multiple
    Optional<productEntity> findById(Long id);

    @@List<productEntity> findByCreatedBy(String email);

   
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/util/List#