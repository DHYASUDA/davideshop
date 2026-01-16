error id: file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/model/cartEntity.java:_empty_/Table#name#
file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/model/cartEntity.java
empty definition using pc, found symbol in pc: _empty_/Table#name#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 710
uri: file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/model/cartEntity.java
text:
```scala
package com.example.davideshop.model;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.example.davideshop.model.userEntity;
@Entity
@Table(@@name = "cart" )
public class cartEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Table#name#