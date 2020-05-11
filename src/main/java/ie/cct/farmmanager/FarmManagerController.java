package ie.cct.farmmanager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// this annotation tells spring that this is a controller
@RestController
public class FarmManagerController {

	// this annotation is used to tell spring to connect a HTTP GET resource to this method
	// so the URL for this method is http://localhost:8080/hello-world
	@GetMapping("hello-world")
	public String hello() {
		return "Hello World!";
	}
	
}
