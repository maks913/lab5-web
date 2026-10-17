package ua.edu.nuos.lab5web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

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
    String city;
    BigDecimal salary;
    String title;
    CompanyDto companyDto;
}