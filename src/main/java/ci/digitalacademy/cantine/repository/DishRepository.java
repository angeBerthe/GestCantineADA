package ci.digitalacademy.cantine.repository;

import ci.digitalacademy.cantine.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
