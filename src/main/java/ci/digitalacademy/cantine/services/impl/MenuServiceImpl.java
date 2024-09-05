package ci.digitalacademy.cantine.services.impl;

import ci.digitalacademy.cantine.models.Menu;
import ci.digitalacademy.cantine.repository.MenuRepository;
import ci.digitalacademy.cantine.services.DishService;
import ci.digitalacademy.cantine.services.MenuService;
import ci.digitalacademy.cantine.services.dto.DishDTO;
import ci.digitalacademy.cantine.services.dto.MenuDTO;
import ci.digitalacademy.cantine.services.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    private final MenuMapper menuMapper;

    @Override
    public MenuDTO save(MenuDTO menuDTO) {
        log.debug("Request to save: {}", menuDTO);
        Menu menu = menuMapper.toEntity(menuDTO);
        menu = menuRepository.save(menu);
        return menuMapper.fromEntity(menu);
    }

    @Override
    public MenuDTO update(MenuDTO menuDTO) {
        log.debug("Request to update: {}", menuDTO);
        return findOne(menuDTO.getId()).map(existingAbsence ->{

            return save(menuDTO);
        }).orElseThrow(()->new IllegalArgumentException());
    }

    @Override
    public Optional<MenuDTO> findOne(Long id) {
        log.debug("Resquest to get id: {}", id);
        return menuRepository.findById(id).map(menu -> {
            return menuMapper.fromEntity(menu);
        });
    }

    @Override
    public List<MenuDTO> findAll() {
        return menuRepository.findAll().stream().map(menu -> {
            return menuMapper.fromEntity(menu);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete {}", id);
        menuRepository.deleteById(id);
    }
}
