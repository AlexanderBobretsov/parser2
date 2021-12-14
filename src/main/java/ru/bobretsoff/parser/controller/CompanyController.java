package ru.bobretsoff.parser.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bobretsoff.parser.model.Company;
import ru.bobretsoff.parser.service.CompanyService;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping(value = "/companies")
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();

    }

}
