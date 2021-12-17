package ru.bobretsoff.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.bobretsoff.parser.model.Company;

import java.util.List;

/** указатель на объект доступа к данным.  */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>, PagingAndSortingRepository<Company, Long> {

    /** собственный JPQL запрос. */
    @Query(value = "select c.id, c.price from Company c where c.ticker = :ticker")
    List<Company> findByName(@Param("ticker") String ticker);

}
