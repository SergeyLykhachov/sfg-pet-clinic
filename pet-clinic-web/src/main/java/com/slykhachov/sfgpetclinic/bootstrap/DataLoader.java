package com.slykhachov.sfgpetclinic.bootstrap;

import com.slykhachov.sfgpetclinic.model.Owner;
import com.slykhachov.sfgpetclinic.model.PetType;
import com.slykhachov.sfgpetclinic.model.Vet;
import com.slykhachov.sfgpetclinic.services.OwnerService;
import com.slykhachov.sfgpetclinic.services.PetTypeService;
import com.slykhachov.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Preston");

        this.ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Robert");
        owner2.setLastName("Gremmy");

        this.ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Dennis");
        vet1.setLastName("Brooks");

        this.vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jake");
        vet2.setLastName("Adami");

        this.vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
