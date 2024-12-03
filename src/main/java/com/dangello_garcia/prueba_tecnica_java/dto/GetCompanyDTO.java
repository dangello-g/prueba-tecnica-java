package com.dangello_garcia.prueba_tecnica_java.dto;

public record GetCompanyDTO(
        String codigo_company,
        String name_company,
        String app_name,
        String version
) {
}
