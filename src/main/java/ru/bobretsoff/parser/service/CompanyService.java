package ru.bobretsoff.parser.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.bobretsoff.parser.model.Company;

import java.util.List;

/**  указание сервисного уровня. */
@Service
public interface CompanyService {


    /** сохрание результат парсинга. */
    void save(Company company);
    /** получение списка компаний. */
    List<Company> getAllCompanies();
    /** получение списка компаний постранично. */
    Page<Company> companyList(Pageable pageable);
    /** получение истории цен по тикеру. */
    List<Company> getByTicker(String ticker);
}
