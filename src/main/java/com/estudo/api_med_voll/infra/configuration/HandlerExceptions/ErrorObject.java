package com.estudo.api_med_voll.infra.configuration.HandlerExceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorObject {
    private final String message;
    private final String field;
    private final Object rejectedValue;
}