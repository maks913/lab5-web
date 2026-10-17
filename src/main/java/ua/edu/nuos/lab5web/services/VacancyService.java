package ua.edu.nuos.lab5web.services;

import org.springframework.stereotype.Service;
import ua.edu.nuos.lab5web.converters.VacancyConvertor;
import ua.edu.nuos.lab5web.dto.VacancyDto;
import ua.edu.nuos.lab5web.repositories.VacancyRepository;

import java.util.List;

@Service
public class VacancyService {

    private final VacancyConvertor vacancyConvertor = new VacancyConvertor();
    private final VacancyRepository vacancyRepository;

    public VacancyService(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    public List<VacancyDto> findAll() {
        return vacancyRepository.findAll()
                .stream()
                .map(vacancyConvertor::convert)
                .toList();
    }

    public void saveVacancy(VacancyDto vacancyDto) {
        vacancyRepository.save(vacancyConvertor.convert(vacancyDto));
    }

    public void deleteVacancy(Integer id) {
        if (id == null) throw new IllegalArgumentException("Id is null");
        vacancyRepository.deleteById(id);
    }

    public VacancyDto findById(Integer id) {
        if (id == null) throw new IllegalArgumentException("Id is null");

        var vacancy = vacancyRepository.findById(id);
        if (vacancy.isPresent()) {
            return vacancy.map(vacancyConvertor::convert)
                    .orElseThrow(() -> new IllegalArgumentException("Vacancy id " + id + " not found."));
        }
        return null;
    }
}
