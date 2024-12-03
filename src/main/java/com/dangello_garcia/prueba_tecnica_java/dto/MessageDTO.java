package com.dangello_garcia.prueba_tecnica_java.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record MessageDTO<T>(
        @NotBlank(message = "Error must exists") boolean error,
        @NotBlank(message = "Answer must exists") T answer
) {
}
