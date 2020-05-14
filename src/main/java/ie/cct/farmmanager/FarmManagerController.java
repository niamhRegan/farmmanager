package ie.cct.farmmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// this annotation tells spring that this is a controller
@RestController
public class FarmManagerController {

	private List<Animal> animals;
	
	public FarmManagerController() {
		animals = new ArrayList<Animal>();
		animals.add(new Animal("cow", 300.0f));
		animals.add(new Animal("pig", 100.0f));
		animals.add(new Animal("chicken", 0.5f));
	}
	
	// POST is used to receive data from the client and create an entity
	// the URL for this method is http://localhost:8080/add-animal
	// returns the list of animals containing the newly added animal
	@PostMapping("add-animal")
	public List<Animal> addAnimal(@RequestBody Animal animal) {
		this.animals.add(animal);
		return animals;
	}

	// this annotation is used to tell spring to connect a HTTP GET resource to this method
	// the URL for this method is http://localhost:8080/average-weight
	@GetMapping("average-weight")
	public Float averageWeight() {
		Float averageWeight = 0.0f;
		for (Animal animal: animals) {
			averageWeight += animal.getWeight();
		}
		averageWeight = averageWeight/animals.size();

		// TODO create an object to return JSON instead of Float
		return averageWeight;
	}

	@GetMapping("count-by-type")
	public Map<String, Integer> countByType() {
		Float minCowWeight = 300.0f;
		Float minPigWeight = 100.0f;
		Float minChickenWeight = 5.0f;		

		// TODO check meets minimum weight
		
		Map<String, Integer> summary = new HashMap<String, Integer>();
		for (Animal animal: animals) {
			if (summary.get(animal.getType()) == null) {
				summary.put(animal.getType(), 1);
			} else {
				Integer count = summary.get(animal.getType());
				summary.put(animal.getType(), count++);
			}			
		}
		return summary;		
	}
	
}
