package ua.edu.nuos.lab5web.converters;

import ua.edu.nuos.lab5web.data.Company;
import ua.edu.nuos.lab5web.dto.CompanyDto;

public class CompanyConvertor {

    public Company convert(CompanyDto companyDto) {
        Company c = new Company();

        c.setId(companyDto.getId());
        c.setName(companyDto.getName());
        c.setDescription(companyDto.getDescription());
        c.setCreatedAt(companyDto.getCreatedAt());
        c.setQuantityEmployees(companyDto.getQuantityEmployees());
        return c;
    }

    public CompanyDto convert(Company company) {
        return new CompanyDto(
                company.getId(),
                company.getCreatedAt(),
                company.getDescription(),
                company.getName(),
                company.getQuantityEmployees()
        );
    }

}
