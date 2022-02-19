package com.poyrazaktas.case2poyrazaktas.srt.util.enums;

public enum SrtStreetMessages {
    NOT_FOUND("Street not found!"),
    NOT_VALID("Street not valid!")
    ;

    private String message;
    SrtStreetMessages(String message) {
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
