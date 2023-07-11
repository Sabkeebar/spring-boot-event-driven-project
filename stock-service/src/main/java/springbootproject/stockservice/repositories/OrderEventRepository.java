package springbootproject.stockservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootproject.basedomainservice.dto.OrderEvent;

//@Repository
@Repository
public interface OrderEventRepository extends JpaRepository<OrderEvent,Long> {
}
