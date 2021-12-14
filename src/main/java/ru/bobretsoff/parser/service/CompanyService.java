package ru.bobretsoff.parser.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.bobretsoff.parser.model.Company;

import java.util.List;

@Service
public interface CompanyService {

    public void save(Company company);
    public List<Company> getAllCompanies();
    public Page<Company> companyList(Pageable pageable);
}
