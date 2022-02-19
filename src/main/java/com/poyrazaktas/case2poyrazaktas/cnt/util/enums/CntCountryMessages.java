package com.poyrazaktas.case2poyrazaktas.cnt.util.enums;

public enum CntCountryMessages {
    NOT_FOUND("Country not found!"),
    NOT_VALID("Country not valid!")
    ;

    private String message;
    CntCountryMessages(String message) {
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
