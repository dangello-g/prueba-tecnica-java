package com.dangello_garcia.prueba_tecnica_java.service.impl;

import com.dangello_garcia.prueba_tecnica_java.dto.CreateCompanyDTO;
import com.dangello_garcia.prueba_tecnica_java.dto.GetCompanyDTO;
import com.dangello_garcia.prueba_tecnica_java.dto.UpdateCompanyDTO;
import com.dangello_garcia.prueba_tecnica_java.exception.CreateCompanyException;
import com.dangello_garcia.prueba_tecnica_java.exception.GetCompanyException;
import com.dangello_garcia.prueba_tecnica_java.exception.UpdateCompanyException;
import com.dangello_garcia.prueba_tecnica_java.model.Company;
import com.dangello_garcia.prueba_tecnica_java.repository.CompanyRepository;
import com.dangello_garcia.prueba_tecnica_java.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public void createCompany(CreateCompanyDTO createCompanyDTO) throws CreateCompanyException {
        if(checkCompanyExistence(createCompanyDTO.id_company()))
            throw new CreateCompanyException("La compañía ya existe");

        if(checkCompanyCodeExistence(createCompanyDTO.codigo_company()))
            throw new CreateCompanyException("El código de esta compañía ya existe");

        Company company =  new Company(createCompanyDTO.id_company(), createCompanyDTO.codigo_company(), createCompanyDTO.name_company(), createCompanyDTO.description_company());
        companyRepository.save(company);
    }

    @Override
    public Company readCompany(int id_company) throws GetCompanyException {
        Optional<Company> company = companyRepository.findById(id_company);

        if(!company.isPresent())
            throw new GetCompanyException("Esta compañía no existe");

        return company.get();
    }

    @Override
    public void updateCompany(UpdateCompanyDTO updateCompanyDTO) throws UpdateCompanyException {
        if(!checkCompanyCodeExistence(updateCompanyDTO.codigo_company()))
            throw new UpdateCompanyException("Esta compañía no existe");

        Optional<Company> opy_company = companyRepository.findByCodigoCompany(updateCompanyDTO.codigo_company());
        Company company = opy_company.get();
        company.setName_company(updateCompanyDTO.name_company());
        company.setDescription_company(updateCompanyDTO.description_company());

        companyRepository.save(company);
    }

    @Override
    public void deleteCompany(String codigo_company) throws GetCompanyException {
        Optional<Company> company = companyRepository.findByCodigoCompany(codigo_company);
        System.out.println(codigo_company);
        if(!company.isPresent())
            throw new GetCompanyException("Esta compañía no existe");

        companyRepository.delete(company.get());
    }

    @Override
    public GetCompanyDTO getCompany(String codigo_company) throws GetCompanyException {
        if(!checkCompanyCodeExistence(codigo_company))
            throw new GetCompanyException("Esta compañía no existe");

        Optional<GetCompanyDTO> company = companyRepository.findByNewCodigoCompany(codigo_company);

        return company.get();
    }

    boolean checkCompanyExistence(int id_company) {
        Optional<Company> company = companyRepository.findById(id_company);
        return company.isPresent();
    }

    boolean checkCompanyCodeExistence(String codigo_company) {
        Optional<Company> company = companyRepository.findByCodigoCompany(codigo_company);
        return company.isPresent();
    }
}
