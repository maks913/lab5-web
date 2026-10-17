package ua.edu.nuos.lab5web.services;

import org.springframework.stereotype.Service;
import ua.edu.nuos.lab5web.converters.CompanyConvertor;
import ua.edu.nuos.lab5web.dto.CompanyDto;
import ua.edu.nuos.lab5web.repositories.CompanyRepository;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyConvertor companyConvertor = new CompanyConvertor();

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CompanyDto> getCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(companyConvertor::convert)
                .toList();
    }

    public void saveCompany(CompanyDto companyDto) {
        companyRepository.save(companyConvertor.convert(companyDto));
    }

    public void deleteCompany(Integer id) {
        if (id == null) throw new IllegalArgumentException("Company id cannot be null");
        companyRepository.deleteById(id);
    }

    public CompanyDto findById(Integer id) {
        if (id == null) throw new IllegalArgumentException("Id is null");

        var company = companyRepository.findById(id);
        if (company.isPresent()) {
            return company.map(companyConvertor::convert)
                    .orElseThrow(() -> new IllegalArgumentException("Company id " + id + " not found."));
        }
        return null;
    }
}
