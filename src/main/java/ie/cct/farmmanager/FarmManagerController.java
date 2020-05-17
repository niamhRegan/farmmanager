package ie.cct.farmmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// this annotation tells spring that this is a controller
@RestController
public class FarmManagerController {

	private List<Animal> animals;

	// constructor create empty list of animals
	public FarmManagerController() {
		animals = new ArrayList<Animal>();
	}
	
	// CA-1
	// this annotation is used to tell sprint to connect a HTTP POST to this method and return JSON
	// it is used to receive data from the client and create an animal
	// the URL for this method is http://localhost:8080/add-animal
	// it creates a new animal and returns the list of animals containing the newly added animal
	@PostMapping(value = "add-animal", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Animal> addAnimal(@RequestBody Animal animal) {
		this.animals.add(animal);
		return animals;
	}

	// CA-2
	// this annotation is used to tell spring to connect a HTTP GET resource to this method and return JSON
	// the URL for this method is http://localhost:8080/average-weight
	// returns the average weight of each type of animal
	@GetMapping(value = "average-weight", produces = MediaType.APPLICATION_JSON_VALUE)
	public Float averageWeight() {
		Float averageWeight = 0.0f;
		for (Animal animal: animals) {
			averageWeight += animal.getWeight();
		}
		averageWeight = averageWeight/animals.size();
		return averageWeight;
	}

	// CA-3
	// this annotation is used to tell spring to connect a HTTP GET resource to this method and return JSON
	// the URL for this method is http://localhost:8080/count-by-type
	// this counts the number of animals of each type
	@GetMapping(value = "count-by-type", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Integer> countByType() {
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

	// CA-4
	// this annotation is used to tell spring to connect a HTTP GET resource to this method and return JSON
	// the URL for this method is http://localhost:8080/current-value
	// returns the current value of full farm stock - only animals that meet min weight requirements
	@GetMapping(value = "current-value", produces = MediaType.APPLICATION_JSON_VALUE)
	public Float currentValue() {
		Float farmValue = 0.0f;
		for (Animal animal : animals) {
			switch (animal.getType()) {
				case "cow":
					if (animal.getWeight() > 300.0f) {
						farmValue += 500.0f;
					}
					break;
					
				case "pig":
					if (animal.getWeight() > 100.0f) {
						farmValue += 250.0f;
					}
					break;

				case "chicken":
					if (animal.getWeight() > 0.5f) {
						farmValue += 5.0f;
					}
					break;
			}
		}
		return farmValue;
	}
	
	// CA-5
	// this annotation is used to tell spring to connect a HTTP GET resource to this method and return JSON
	// this will map the URL http://localhost:8080/current-value to this code 
	// you must supply a the current price of all 3 animals cow pig and chicken
	// e.g http://localhost:8080/current-value-prices?cow=450&pig=220&chicken=2
	// returns the current value of full farm stock - only animals that meet min weight requirements
	@GetMapping(value = "current-value-prices", produces = MediaType.APPLICATION_JSON_VALUE)
	public Float totalValue() {
		// TODO get price request parameters and use in currentValue method
		return this.currentValue();
	}
	
}
