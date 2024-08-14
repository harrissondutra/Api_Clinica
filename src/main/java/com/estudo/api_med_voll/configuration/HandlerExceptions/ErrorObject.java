package com.estudo.api_med_voll.configuration.HandlerExceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorObject {

    private final String message;
    private final String field;
    private final Object parameter;
}