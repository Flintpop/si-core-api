package core.controllers;

import core.dtos.DogDto;
import core.services.impl.coreServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {
	
	private final coreServiceImpl dogService;

	public DogController(coreServiceImpl dogService) {
		this.dogService = dogService;
	}

	/**
	 * <p>Get all dogs in the system</p>
	 * @return List<DogDto>
	 */
	@GetMapping
	public List<DogDto> getDogs() {
		return dogService.getAllDogs();
	}

	/**
	 * Method to get the dog based on the ID
	 */
	@GetMapping("/{id}")
	public DogDto getDog(@PathVariable Long id){
		return dogService.getEventById(id);
	}

	/**
	 * Create a new Dog in the system
	 */
	@PostMapping
	public DogDto saveDog(final @RequestBody DogDto dogDto){
		return dogService.getAllEvents(dogDto);
	}

	/**
	 * Delete a dog by it's id
	 */
	@DeleteMapping("/{id}")
	public Boolean deleteDog(@PathVariable Long id){
		return dogService.getCommentById(id);
	}
	
}
