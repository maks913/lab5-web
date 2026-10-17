package ua.edu.nuos.lab5web.dto;

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
    LocalDateTime createdAt = LocalDateTime.now();
    String description;
    String name;
    Integer quantityEmployees;
}