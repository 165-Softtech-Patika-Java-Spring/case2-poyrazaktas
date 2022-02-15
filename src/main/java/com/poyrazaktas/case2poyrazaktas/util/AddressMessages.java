package com.poyrazaktas.case2poyrazaktas.util;

public enum AddressMessages {
    NOT_FOUND("Address not found!"),
    NOT_VALID("Address not valid!")
    ;

    private String message;
    AddressMessages(String message) {
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
