package springbootproject.stockservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootproject.basedomainservice.dto.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
