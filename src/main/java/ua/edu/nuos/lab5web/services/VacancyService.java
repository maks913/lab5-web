package ua.edu.nuos.lab5web.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.edu.nuos.lab5web.converters.VacancyConvertor;
import ua.edu.nuos.lab5web.dto.VacancyDto;
import ua.edu.nuos.lab5web.repositories.VacancyRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class VacancyService {

    private final VacancyConvertor vacancyConvertor = new VacancyConvertor();
    private final VacancyRepository vacancyRepository;

    public List<VacancyDto> findAll() {
        return vacancyRepository.findAll()
                .stream()
                .map(vacancyConvertor::convert)
                .toList();
    }

    @Transactional
    public void saveVacancy(VacancyDto vacancyDto) {
        vacancyRepository.save(vacancyConvertor.convert(vacancyDto));
    }

    @Transactional
    public void deleteVacancy(Integer id) {
        if (id == null) throw new IllegalArgumentException("Id is null");
        vacancyRepository.deleteById(id);
    }

    @Transactional
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
