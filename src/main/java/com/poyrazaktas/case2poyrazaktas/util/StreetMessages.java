package com.poyrazaktas.case2poyrazaktas.util;

public enum StreetMessages {
    NOT_FOUND("Street not found!"),
    NOT_VALID("Street not valid!")
    ;

    private String message;
    StreetMessages(String message) {
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
