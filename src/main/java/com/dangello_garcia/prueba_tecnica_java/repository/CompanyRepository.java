package com.dangello_garcia.prueba_tecnica_java.repository;

import com.dangello_garcia.prueba_tecnica_java.dto.GetCompanyDTO;
import com.dangello_garcia.prueba_tecnica_java.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository  extends JpaRepository<Company, Integer> {

    Optional<Company> findByCodigoCompany(String codigoCompany);

    @Query("""
        SELECT new com.dangello_garcia.prueba_tecnica_java.dto.GetCompanyDTO(
            c.codigoCompany, c.name_company, a.app_name, v.version
        )
        FROM VersionCompany vc
        JOIN vc.company c
        JOIN vc.version v
        JOIN v.application a
        WHERE c.codigoCompany = :codigoCompany
    """)
    Optional<GetCompanyDTO> findByNewCodigoCompany(@Param("codigoCompany") String codigoCompany);

}
