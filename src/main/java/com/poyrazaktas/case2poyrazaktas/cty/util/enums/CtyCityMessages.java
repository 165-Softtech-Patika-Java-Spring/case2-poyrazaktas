package com.poyrazaktas.case2poyrazaktas.cty.util.enums;

public enum CtyCityMessages {
    NOT_FOUND("City not found!"),
    NOT_VALID("City not valid!")
    ;

    private String message;
    CtyCityMessages(String message) {
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
