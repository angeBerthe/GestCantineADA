package ci.digitalacademy.cantine.services;

import ci.digitalacademy.cantine.services.dto.MenuDTO;

import java.util.List;
import java.util.Optional;

public interface MenuService {

    MenuDTO save(MenuDTO menuDTO);

    MenuDTO update(MenuDTO menuDTO);

    Optional<MenuDTO> findOne(Long id);

    List<MenuDTO> findAll();

    void delete(Long id);
}
