package ru.bobretsoff.parser.controller;


import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping("/api/companies/")
    public Page<Company> readPageable(@NotNull final Pageable pageable) {
        return companyService.companyList(pageable);
    }

}
