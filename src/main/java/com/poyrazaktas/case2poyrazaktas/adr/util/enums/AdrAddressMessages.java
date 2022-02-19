package com.poyrazaktas.case2poyrazaktas.adr.util.enums;

public enum AdrAddressMessages {
    NOT_FOUND("Address not found!"),
    NOT_VALID("Address not valid!")
    ;

    private String message;
    AdrAddressMessages(String message) {
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
