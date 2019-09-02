package com.slykhachov.sfgpetclinic.bootstrap;

import com.slykhachov.sfgpetclinic.model.*;
import com.slykhachov.sfgpetclinic.services.OwnerService;
import com.slykhachov.sfgpetclinic.services.PetTypeService;
import com.slykhachov.sfgpetclinic.services.SpecialtyService;
import com.slykhachov.sfgpetclinic.services.VetService;
import com.slykhachov.sfgpetclinic.services.VisitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() == 0) {
            initData();
        }
    }

    private void initData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = this.specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = this.specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = this.specialtyService.save(dentistry);


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

        Visit catVisit = new Visit();
        catVisit.setPet(robertsPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy kitty");
        visitService.save(catVisit);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Dennis");
        vet1.setLastName("Brooks");
        vet1.getSpecialties().add(savedRadiology);

        this.vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jake");
        vet2.setLastName("Adami");
        vet2.getSpecialties().add(savedSurgery);

        this.vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
