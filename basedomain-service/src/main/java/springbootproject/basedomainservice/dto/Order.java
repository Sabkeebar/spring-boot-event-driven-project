package springbootproject.basedomainservice.dto;



import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue

private  Long id;
    private     String orderId;
    private     String name;
    private     int quantity;
    private     double price;
}
