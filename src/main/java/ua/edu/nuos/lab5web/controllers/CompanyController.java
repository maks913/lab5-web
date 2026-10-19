package ua.edu.nuos.lab5web.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.edu.nuos.lab5web.dto.CompanyDto;
import ua.edu.nuos.lab5web.services.CompanyService;

import java.util.List;

@Controller
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public String getAll(Model model) {
        List<CompanyDto> companies = companyService.getCompanies();
        model.addAttribute("companies", companies);
        model.addAttribute("company", new CompanyDto());
        model.addAttribute("companyEdit", new CompanyDto());
        return "company";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute CompanyDto companyDto) {
        companyService.saveCompany(companyDto);
        return "redirect:/company";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        companyService.deleteCompany(id);
        return "redirect:/company";
    }

    @GetMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<CompanyDto> editCompany(@PathVariable Integer id) {
        CompanyDto response = companyService.findById(id);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
