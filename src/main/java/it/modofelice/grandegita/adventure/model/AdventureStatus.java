package it.modofelice.grandegita.adventure.model;

public enum AdventureStatus {
    CREATED("CREATED"),
    ACTIVE("ACTIVE"),
    CANCELED("CANCELED"),
    FINISHED("FINISHED");

    private final String status;

    AdventureStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }
}
