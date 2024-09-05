package ci.digitalacademy.cantine.controllers;

import ci.digitalacademy.cantine.models.Dish;
import ci.digitalacademy.cantine.services.DishService;
import ci.digitalacademy.cantine.services.dto.DishDTO;
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
@RequestMapping("/dishs")
@RequiredArgsConstructor
@Slf4j
public class DishController {

    private final DishService dishService;

    @GetMapping("/add")
    public String showAddDishPage(Model model){
        model.addAttribute("dish", new  DishDTO());
        return "dishs/forms";
    }

    @GetMapping
    public String showDishPage(Model model){
     List<DishDTO> dishDTOS = dishService.findAll();
    model.addAttribute("dishs", dishDTOS);
    return "dishs/plats";
    }

    @PostMapping
    public String saveDish( DishDTO dishDTO){
        log.debug("Request to save dish {}", dishDTO);
        dishService.save(dishDTO);
        return "redirect:/dishs";
    }

    @GetMapping("/{id}")
    public String showUpdateDishForms(@PathVariable Long id, Model model){
        log.debug("Request to show update dish forms");
        Optional<DishDTO> dishDTO = dishService.findOne(id);
        if (dishDTO.isPresent()){
            model.addAttribute("dish", dishDTO.get());
            return "dishs/forms";
        }else {
            return "redirect:/dishs";
        }


    }

    @PostMapping("/{id}")
    public String deleteDish(@PathVariable Long id) {
        dishService.delete(id);
        return "redirect:/dishs";
    }
}
