package ua.edu.nuos.lab5web.converters;

import ua.edu.nuos.lab5web.data.Vacancy;
import ua.edu.nuos.lab5web.dto.VacancyDto;

public class VacancyConvertor {
    private final CompanyConvertor companyConvertor = new CompanyConvertor();

    public Vacancy convert(VacancyDto vacancyDto) {
        Vacancy v = new Vacancy();

        v.setId(vacancyDto.getId());
        v.setCity(vacancyDto.getCity());
        v.setTitle(vacancyDto.getTitle());
        v.setSalary(vacancyDto.getSalary());
        v.setCompany(companyConvertor.convert(vacancyDto.getCompanyDto()));
        return v;
    }

    public VacancyDto convert(Vacancy vacancy) {
        return new VacancyDto(
                vacancy.getId(),
                vacancy.getCity(),
                vacancy.getSalary(),
                vacancy.getTitle(),
                companyConvertor.convert(vacancy.getCompany())
        );
    }

}
