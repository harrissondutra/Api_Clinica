package com.estudo.api_med_voll.configuration.HandlerExceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final String message;
    private final int code;
    private final List<ErrorObject> errors;

    public ErrorResponse(String message, int code) {
        this.message = message;
        this.code = code;
        this.errors = null;
    }


}