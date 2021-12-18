package ru.bobretsoff.parser.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.bobretsoff.parser.model.Company;
import ru.bobretsoff.parser.model.CompanyProjection;
import ru.bobretsoff.parser.service.CompanyService;

import java.util.Collection;
import java.util.List;

/** указание специального контроллера, используемого в веб-сервисах RESTFul, и эквивалента @Controller + @ResponseBody. */
@RestController
public class CompanyController {
    /** автоматическая инъекция зависимости.*/
    @Autowired
    /** инъекция интерфейса CompanyService.*/
    private CompanyService companyService;

    /** обработчик get-запроса /companies. */
    @GetMapping(value = "/companies")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    /** обработчик get-запроса /api/companies/. */
    @GetMapping("/api/companies/")
    public Page<Company> readPageable(@NotNull final Pageable pageable) {
        return companyService.companyList(pageable);
    }

    /** обработчик get-запроса /api/companies/{ticker}/prices. */
    @GetMapping("/api/companies/{ticker}/prices")
    public List<CompanyProjection> getByTicker(@PathVariable("ticker") String ticker) {
        return companyService.getByTicker(ticker);
    }


}
