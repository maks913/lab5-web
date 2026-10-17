package ua.edu.nuos.lab5web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.edu.nuos.lab5web.dto.VacancyDto;
import ua.edu.nuos.lab5web.services.CompanyService;
import ua.edu.nuos.lab5web.services.VacancyService;

@Controller
@RequestMapping("/vacancy")
public class VacancyController {
    private final VacancyService vacancyService;
    private final CompanyService companyService;

    public VacancyController(VacancyService vacancyService, CompanyService companyService) {
        this.vacancyService = vacancyService;
        this.companyService = companyService;
    }

    @GetMapping
    public String getVacancies(Model model) {
        var vacancies = vacancyService.findAll();
        var companies = companyService.getCompanies();

        model.addAttribute("vacancies", vacancies);
        model.addAttribute("companies", companies);
        model.addAttribute("vacancy", new VacancyDto());
        model.addAttribute("vacancyEdit", new VacancyDto());
        
        return "vacancy";
    }

    @PostMapping("/save")
    public String saveVacancy(VacancyDto vacancyDto) {
        vacancyService.saveVacancy(vacancyDto);
        return "redirect:/vacancy";
    }

    @PostMapping("/delete/{id}")
    public String deleteVacancy(@PathVariable Integer id) {
        vacancyService.deleteVacancy(id);
        return "redirect:/vacancy";
    }

    @GetMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<VacancyDto> editVacancy(@PathVariable Integer id) {
        VacancyDto response = vacancyService.findById(id);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
