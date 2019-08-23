package com.slykhachov.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet {
    private PetType petType;
    private Owner owner;
    private LocalDate birthDaate;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDaate() {
        return birthDaate;
    }

    public void setBirthDaate(LocalDate birthDaate) {
        this.birthDaate = birthDaate;
    }
}
