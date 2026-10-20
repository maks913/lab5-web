package ua.edu.nuos.lab5web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link ua.edu.nuos.lab5web.data.Vacancy}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacancyDto implements Serializable {
    Integer id;

    @NotBlank(message = "City cannot be blank")
    String city;

    @NotNull
    BigDecimal salary;

    @NotBlank(message = "Title cannot be blank!")
    String title;

    @NotNull
    CompanyDto companyDto;
}