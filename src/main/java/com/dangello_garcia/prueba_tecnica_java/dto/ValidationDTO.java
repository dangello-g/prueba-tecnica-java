package com.dangello_garcia.prueba_tecnica_java.dto;

import jakarta.validation.constraints.NotBlank;

public record ValidationDTO(
        @NotBlank(message = "Field must exists") String field,
        @NotBlank(message = "Error must exists") String error) {
}
