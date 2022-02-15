package com.poyrazaktas.case2poyrazaktas.util;

public enum DistrictMessages {
    NOT_FOUND("District not found!"),
    NOT_VALID("District not valid!")
    ;

    private String message;
    DistrictMessages(String message) {
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
