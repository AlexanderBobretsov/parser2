package ru.bobretsoff.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.bobretsoff.parser.model.Company;
import ru.bobretsoff.parser.model.CompanyProjection;

import java.util.List;

/** указатель на объект доступа к данным.  */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>, PagingAndSortingRepository<Company, Long> {

   /** выводим историю цен по тикеру.  */
   List<CompanyProjection> findByTicker(@Param("ticker") String ticker);

}
