package com.poyrazaktas.case2poyrazaktas.util;

public enum CountryMessages {
    NOT_FOUND("Country not found!"),
    NOT_VALID("Country not valid!")
    ;

    private String message;
    CountryMessages(String message) {
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
