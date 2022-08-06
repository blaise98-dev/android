package com.example.smell.model;

public class SmellTypesModal {
    int id;
    String smellType, smellDescriptions;
    boolean hasImageReference;

    public SmellTypesModal(String smellType, String smellDescriptions, boolean hasImageReference, int id) {
        this.id = id + 1;
        this.smellType = smellType;
        this.smellDescriptions = smellDescriptions;
        this.hasImageReference = hasImageReference;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSmellType() {
        return smellType;
    }

    public void setSmellType(String smellType) {
        this.smellType = smellType;
    }

    public String getSmellDescriptions() {
        return smellDescriptions;
    }

    public void setSmellDescriptions(String smellDescriptions) {
        this.smellDescriptions = smellDescriptions;
    }

    public boolean isHasImageReference() {
        return hasImageReference;
    }

    public void setHasImageReference(boolean hasImageReference) {
        this.hasImageReference = hasImageReference;
    }
}
