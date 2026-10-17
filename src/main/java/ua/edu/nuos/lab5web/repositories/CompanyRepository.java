package ua.edu.nuos.lab5web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.nuos.lab5web.data.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}