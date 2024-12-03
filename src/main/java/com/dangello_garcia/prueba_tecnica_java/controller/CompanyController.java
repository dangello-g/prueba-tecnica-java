package com.dangello_garcia.prueba_tecnica_java.controller;

import com.dangello_garcia.prueba_tecnica_java.dto.CreateCompanyDTO;
import com.dangello_garcia.prueba_tecnica_java.dto.GetCompanyDTO;
import com.dangello_garcia.prueba_tecnica_java.dto.MessageDTO;
import com.dangello_garcia.prueba_tecnica_java.dto.UpdateCompanyDTO;
import com.dangello_garcia.prueba_tecnica_java.exception.CreateCompanyException;
import com.dangello_garcia.prueba_tecnica_java.exception.GetCompanyException;
import com.dangello_garcia.prueba_tecnica_java.exception.UpdateCompanyException;
import com.dangello_garcia.prueba_tecnica_java.model.Company;
import com.dangello_garcia.prueba_tecnica_java.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<MessageDTO<String>> createCompany(@RequestBody CreateCompanyDTO createCompanyDTO) throws CreateCompanyException {
        companyService.createCompany(createCompanyDTO);
        return ResponseEntity.ok().body( new MessageDTO<>(false, "Company registered succesfully"));
    }

    @GetMapping("/get")
    public Company readCompany(@RequestParam int id_company) throws GetCompanyException {
        return companyService.readCompany(id_company);
    }

    @PatchMapping("/update")
    public ResponseEntity<MessageDTO<String>> updateCompany(@RequestBody UpdateCompanyDTO updateCompanyDTO) throws UpdateCompanyException {
        companyService.updateCompany(updateCompanyDTO);
        return ResponseEntity.ok().body( new MessageDTO<>(false, "Company updated succesfully"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<MessageDTO<String>> deleteCompany(@RequestParam String codigo_company) throws GetCompanyException {
        companyService.deleteCompany(codigo_company);
        return ResponseEntity.ok().body( new MessageDTO<>(false, "Company deleted succesfully"));
    }

    @GetMapping("/get-company")
    public GetCompanyDTO getCompany(@RequestParam String codigo_company) throws GetCompanyException {
        return companyService.getCompany(codigo_company);
    }
}
