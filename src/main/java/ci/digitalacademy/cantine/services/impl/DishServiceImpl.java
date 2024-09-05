package ci.digitalacademy.cantine.services.impl;

import ci.digitalacademy.cantine.models.Dish;
import ci.digitalacademy.cantine.models.Menu;
import ci.digitalacademy.cantine.repository.DishRepository;
import ci.digitalacademy.cantine.services.DishService;
import ci.digitalacademy.cantine.services.dto.DishDTO;
import ci.digitalacademy.cantine.services.mapper.DishMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
@Slf4j
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    private final DishMapper dishMapper;
    @Override
    public DishDTO save(DishDTO dishDTO) {
        log.debug("Request to save: {}", dishDTO);
        Dish dish = dishMapper.toEntity(dishDTO);
        dish = dishRepository.save(dish);
        return dishMapper.fromEntity(dish);
    }

    @Override
    public DishDTO update(DishDTO dishDTO) {
        log.debug("Request to update: {}", dishDTO);
        return findOne(dishDTO.getId()).map(existingDish ->{
            existingDish.setName(dishDTO.getName());
            existingDish.setSummary(existingDish.getSummary());
            return save(dishDTO);
        }).orElseThrow(()->new IllegalArgumentException());
    }

    @Override
    public Optional<DishDTO> findOne(Long id) {
        log.debug("Resquest to get id: {}", id);
        return dishRepository.findById(id).map(menu -> {
            return dishMapper.fromEntity(menu);
        });
    }

    @Override
    public List<DishDTO> findAll() {
        return dishRepository.findAll().stream().map(menu -> {
            return dishMapper.fromEntity(menu);
        }).toList();
    }

    @Override
    public void delete(Long id) {

        log.debug("Request to delete {}", id);
        dishRepository.deleteById(id);

    }
}
