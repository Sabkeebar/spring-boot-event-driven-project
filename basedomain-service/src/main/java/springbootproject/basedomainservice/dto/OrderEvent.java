package springbootproject.basedomainservice.dto;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString

public class OrderEvent {
    @Id
    @GeneratedValue
 private    Long id ;
    private  String message;
    private  String status;
@ManyToOne(cascade = CascadeType.ALL)

   private  Order order;
}
