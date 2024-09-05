package ci.digitalacademy.cantine.services.dto;

import ci.digitalacademy.cantine.models.Dish;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class MenuDTO {

    private Long id;


    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date creation_date;

    private Dish dish;
}
