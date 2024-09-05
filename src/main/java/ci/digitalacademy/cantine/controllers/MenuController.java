package ci.digitalacademy.cantine.controllers;

import ci.digitalacademy.cantine.models.Dish;
import ci.digitalacademy.cantine.models.Menu;
import ci.digitalacademy.cantine.services.DishService;
import ci.digitalacademy.cantine.services.MenuService;
import ci.digitalacademy.cantine.services.dto.DishDTO;
import ci.digitalacademy.cantine.services.dto.MenuDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/menus")
public class MenuController {

    private final MenuService menuService;
    private final DishService dishService;

    @GetMapping("/add")
    public String showAddMenuPage(Model model){
        model.addAttribute("menu", new MenuDTO());
        List<DishDTO> dishDTOS = dishService.findAll();
        model.addAttribute("dishs", dishDTOS);
        return "menus/forms";
    }

    @GetMapping
    public String showMenuPage(Model model){
        List<MenuDTO> menuDTOS = menuService.findAll();
        model.addAttribute("menus", menuDTOS);
        return "menus/menus";
    }

    @PostMapping
    public String saveMenu( MenuDTO menuDTO){
        log.debug("Request to save menu {}", menuDTO);
        menuService.save(menuDTO);
        return "redirect:/menus";
    }

    @GetMapping("/{id}")
    public String showUpdateMenuForms(@PathVariable Long id, Model model){
        log.debug("Request to show update menus forms");
        Optional<MenuDTO> menuDTO = menuService.findOne(id);
        List<DishDTO> dishDTOs = dishService.findAll();
        if (menuDTO.isPresent()){
            model.addAttribute("menu", menuDTO.get());
            model.addAttribute("dish", dishDTOs);
            return "menus/forms";
        }else {
            return "redirect:/menus";
        }


    }

    @PostMapping("/{id}")
    public String deleteMenu(@PathVariable Long id) {
        menuService.delete(id);
        return "redirect:/menus";
    }
}
