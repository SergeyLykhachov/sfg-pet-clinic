package com.slykhachov.sfgpetclinic.bootstrap;

import com.slykhachov.sfgpetclinic.model.Owner;
import com.slykhachov.sfgpetclinic.model.Pet;
import com.slykhachov.sfgpetclinic.model.PetType;
import com.slykhachov.sfgpetclinic.model.Vet;
import com.slykhachov.sfgpetclinic.services.OwnerService;
import com.slykhachov.sfgpetclinic.services.PetTypeService;
import com.slykhachov.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("123 Main Str.");
        owner1.setCity("Maiamy");
        owner1.setTelephone("1231231231");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        this.ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Robert");
        owner2.setLastName("Gremmy");
        owner2.setAddress("123 Main Str.");
        owner2.setCity("Maiamy");
        owner2.setTelephone("1231231231");

        Pet robertsPet = new Pet();
        robertsPet.setPetType(savedCatPetType);
        robertsPet.setOwner(owner2);
        robertsPet.setBirthDate(LocalDate.now());
        robertsPet.setName("Meow");
        owner2.getPets().add(robertsPet);

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
