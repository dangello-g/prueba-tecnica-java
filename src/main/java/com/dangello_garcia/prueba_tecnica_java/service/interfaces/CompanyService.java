package com.dangello_garcia.prueba_tecnica_java.service.interfaces;

import com.dangello_garcia.prueba_tecnica_java.dto.CreateCompanyDTO;
import com.dangello_garcia.prueba_tecnica_java.dto.GetCompanyDTO;
import com.dangello_garcia.prueba_tecnica_java.dto.UpdateCompanyDTO;
import com.dangello_garcia.prueba_tecnica_java.exception.CreateCompanyException;
import com.dangello_garcia.prueba_tecnica_java.exception.GetCompanyException;
import com.dangello_garcia.prueba_tecnica_java.exception.UpdateCompanyException;
import com.dangello_garcia.prueba_tecnica_java.model.Company;

public interface CompanyService {
    void createCompany(CreateCompanyDTO createCompanyDTO) throws CreateCompanyException;

    Company readCompany(int id_company) throws GetCompanyException;

    void updateCompany(UpdateCompanyDTO updateCompanyDTO) throws UpdateCompanyException;

    void deleteCompany(String codigo_company) throws GetCompanyException;

    GetCompanyDTO getCompany(String codigo_company) throws GetCompanyException;

}
