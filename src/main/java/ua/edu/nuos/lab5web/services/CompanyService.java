package ua.edu.nuos.lab5web.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.edu.nuos.lab5web.converters.CompanyConvertor;
import ua.edu.nuos.lab5web.dto.CompanyDto;
import ua.edu.nuos.lab5web.repositories.CompanyRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyConvertor companyConvertor = new CompanyConvertor();
    private final CompanyRepository companyRepository;

    public List<CompanyDto> getCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(companyConvertor::convert)
                .toList();
    }

    @Transactional
    public void saveCompany(CompanyDto companyDto) {
        companyRepository.save(companyConvertor.convert(companyDto));
    }

    @Transactional
    public void deleteCompany(Integer id) {
        if (id == null) throw new IllegalArgumentException("Company id cannot be null");
        companyRepository.deleteById(id);
    }

    @Transactional
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
