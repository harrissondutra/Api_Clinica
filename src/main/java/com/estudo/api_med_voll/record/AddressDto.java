package com.estudo.api_med_voll.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDto(
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @NotBlank
        @Pattern(regexp = "\\d{8}", message = "{cep.not.correct.size}")
        String cep,
        @NotBlank
        String city,
        @NotBlank
        String uf,

        String number,
        String complement
) {
}
