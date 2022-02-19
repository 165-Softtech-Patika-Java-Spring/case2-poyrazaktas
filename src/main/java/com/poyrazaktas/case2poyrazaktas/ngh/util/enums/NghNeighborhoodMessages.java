package com.poyrazaktas.case2poyrazaktas.ngh.util.enums;

public enum NghNeighborhoodMessages {
    NOT_FOUND("Neighborhood not found!"),
    NOT_VALID("Neighborhood not valid!")
    ;

    private String message;
    NghNeighborhoodMessages(String message) {
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
