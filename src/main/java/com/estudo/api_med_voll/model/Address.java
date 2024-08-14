package com.estudo.api_med_voll.model;

import com.estudo.api_med_voll.record.AddressDto;
import jakarta.persistence.Embeddable;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

    private String street;
    private String neighborhood;
    private String cep;
    private String city;
    private String uf;
    private String number;
    private String complement;

    public Address(AddressDto address) {
        if (address != null) {
            this.street = address.street();
            this.neighborhood = address.neighborhood();
            this.cep = address.cep();
            this.city = address.city();
            this.uf = address.uf();
            this.number = address.number();
            this.complement = address.complement();
        }
    }
}
