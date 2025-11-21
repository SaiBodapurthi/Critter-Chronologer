package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.service.PetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Pet pet = convertDTOToPet(petDTO);
        // We pass the ownerId separately because the Entity doesn't have it yet
        Pet savedPet = petService.savePet(pet, petDTO.getOwnerId());
        return convertPetToDTO(savedPet);
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        Pet pet = petService.getPet(petId);
        return convertPetToDTO(pet);
    }

    @GetMapping
    public List<PetDTO> getPets(){
        List<Pet> pets = petService.getAllPets();
        return pets.stream().map(this::convertPetToDTO).collect(Collectors.toList());
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        List<Pet> pets = petService.getPetsByOwner(ownerId);
        return pets.stream().map(this::convertPetToDTO).collect(Collectors.toList());
    }

    // --- Helper Methods ---

    private PetDTO convertPetToDTO(Pet pet){
        PetDTO dto = new PetDTO();
        BeanUtils.copyProperties(pet, dto);
        // Manually set the ownerId from the Customer object
        if(pet.getCustomer() != null){
            dto.setOwnerId(pet.getCustomer().getId());
        }
        return dto;
    }

    private Pet convertDTOToPet(PetDTO dto){
        Pet pet = new Pet();
        BeanUtils.copyProperties(dto, pet);
        return pet;
    }
}