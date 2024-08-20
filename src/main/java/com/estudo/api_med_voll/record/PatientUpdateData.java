package com.estudo.api_med_voll.record;

import jakarta.validation.constraints.NotNull;

public record PatientUpdateData(
        @NotNull Long id,
        String name,
        String phone,
        AddressData addressData
) {
}
