package com.poyrazaktas.case2poyrazaktas.dst.util.enums;

public enum DstDistrictMessages {
    NOT_FOUND("District not found!"),
    NOT_VALID("District not valid!")
    ;

    private String message;
    DstDistrictMessages(String message) {
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
