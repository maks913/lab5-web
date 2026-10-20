package ua.edu.nuos.lab5web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link ua.edu.nuos.lab5web.data.Company}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto implements Serializable {
    Integer id;
    LocalDateTime createdAt;
    String description;
    @NotBlank
    String name;
    @NotNull
    Integer quantityEmployees;
}