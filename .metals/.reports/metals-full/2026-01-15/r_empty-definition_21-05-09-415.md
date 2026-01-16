error id: file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/model/cartEntity.java:jakarta/persistence/GeneratedValue#
file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/model/cartEntity.java
empty definition using pc, found symbol in pc: jakarta/persistence/GeneratedValue#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 107
uri: file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/model/cartEntity.java
text:
```scala
package com.example.davideshop.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Gener@@atedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "cart" )
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

empty definition using pc, found symbol in pc: jakarta/persistence/GeneratedValue#