package com.poyrazaktas.case2poyrazaktas.util;

public enum NeighborhoodMessages {
    NOT_FOUND("Neighborhood not found!"),
    NOT_VALID("Neighborhood not valid!")
    ;

    private String message;
    NeighborhoodMessages(String message) {
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
