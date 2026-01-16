error id: file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/model/cartEntity.java:_empty_/OneToMany#cascade#
file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/model/cartEntity.java
empty definition using pc, found symbol in pc: _empty_/OneToMany#cascade#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 754
uri: file:///C:/Users/david/Desktop/davideshop/src/main/java/com/example/davideshop/model/cartEntity.java
text:
```scala
package com.example.davideshop.model;
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
@Table(name = "cart" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class cartEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private userEntity user;

    @OneToMany(mappedBy = "cart", cascad@@e = CascadeType.ALL, orphanRemoval = true)
    private List<cartEntity> cartItems = new ArrayList<>();

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
   
    
   
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/OneToMany#cascade#