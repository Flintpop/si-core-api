package core.services.impl;

import core.dtos.DogDto;
import core.entities.Dog;
import core.repositories.DogRepository;
import core.services.coreService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("dogService")
public class coreServiceImplBackup implements coreService {

	private final DogRepository dogRepository;

    public coreServiceImplBackup(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    @Override
    public DogDto getAllEvents(DogDto dogDto) {
        // Converts the dto to the dog entity
        Dog dog = dogDtoToEntity(dogDto);
        // Save the dog entity
        dog = dogRepository.save(dog);
        // Return the new dto
        return dogEntityToDto(dog);
    }

    @Override
    public DogDto getEventById(Long dogId) {
        Dog dog = dogRepository.findById(dogId).orElseThrow(() -> new EntityNotFoundException("Dog not found"));
        return dogEntityToDto(dog);
    }

    @Override
    public boolean getCommentById(Long dogId) {
        dogRepository.deleteById(dogId);
        return true;
    }

    @Override
    public List<DogDto> getAllDogs() {
        List<DogDto> dogDtos = new ArrayList<>();
        List<Dog> dogs = dogRepository.findAll();
        dogs.forEach(dog -> {
            dogDtos.add(dogEntityToDto(dog));
        });
        return dogDtos;
    }

    /**
     * Map dog dto to dog entity
     */
    private DogDto dogEntityToDto(Dog dog){
        DogDto dogDto = new DogDto();
        dogDto.setId(dog.getId());
        dogDto.setName(dog.getName());
        dogDto.setRace(dog.getRace());
        return dogDto;
    }

    /**
     * Map dog entity to dog dto
     */
    private Dog dogDtoToEntity(DogDto dogDto){
        Dog dog = new Dog();
        dog.setName(dogDto.getName());
        dog.setId(dogDto.getId());
        dog.setRace(dogDto.getRace());
        return dog;
    }
}
