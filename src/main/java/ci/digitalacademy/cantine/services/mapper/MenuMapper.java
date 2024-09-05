package ci.digitalacademy.cantine.services.mapper;

import ci.digitalacademy.cantine.models.Menu;
import ci.digitalacademy.cantine.services.dto.MenuDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuMapper extends EntityMapper<MenuDTO, Menu> {
}
