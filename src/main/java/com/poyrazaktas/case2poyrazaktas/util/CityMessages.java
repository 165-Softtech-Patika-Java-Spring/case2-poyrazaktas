package com.poyrazaktas.case2poyrazaktas.util;

public enum CityMessages {
    NOT_FOUND("City not found!"),
    NOT_VALID("City not valid!")
    ;

    private String message;
    CityMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
