package ua.edu.nuos.lab5web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.nuos.lab5web.data.Vacancy;

public interface VacancyRepository extends JpaRepository<Vacancy, Integer> {
}