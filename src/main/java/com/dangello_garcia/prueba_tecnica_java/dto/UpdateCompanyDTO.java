package com.dangello_garcia.prueba_tecnica_java.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateCompanyDTO(
        @NotBlank String codigo_company,
        @NotBlank String name_company,
        @NotBlank String description_company
) {
}
