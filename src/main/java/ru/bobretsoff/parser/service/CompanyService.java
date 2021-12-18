package ru.bobretsoff.parser.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.bobretsoff.parser.model.Company;
import ru.bobretsoff.parser.model.CompanyProjection;

import java.util.List;

/**  указание сервисного уровня. */
@Service
public interface CompanyService {


    /** сохрание результат парсинга в таблицу Company. */
    void save(Company company);
    /** получение списка компаний. */
    List<Company> getAllCompanies();
    /** получение списка компаний постранично. */
    Page<Company> companyList(Pageable pageable);
    /** получение истории цен по тикеру. */
    List<CompanyProjection> getByTicker(String ticker);
}
