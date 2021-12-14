package ru.bobretsoff.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bobretsoff.parser.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
