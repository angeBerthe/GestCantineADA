package ci.digitalacademy.cantine.services.mapper;

import ci.digitalacademy.cantine.models.Dish;
import ci.digitalacademy.cantine.services.dto.DishDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DishMapper extends EntityMapper<DishDTO, Dish> {
}
