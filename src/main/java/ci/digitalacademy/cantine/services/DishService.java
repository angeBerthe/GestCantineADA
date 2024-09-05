package ci.digitalacademy.cantine.services;

import ci.digitalacademy.cantine.services.dto.DishDTO;

import java.util.List;
import java.util.Optional;

public interface DishService {


    DishDTO save(DishDTO dishDTO);

    DishDTO update(DishDTO dishDTO);

    Optional<DishDTO> findOne(Long id);

    List<DishDTO> findAll();

    void delete(Long id);
}
