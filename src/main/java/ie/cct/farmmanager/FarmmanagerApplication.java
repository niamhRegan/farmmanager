package ie.cct.farmmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

@SpringBootApplication

// tell spring where to scan to find our components e.g. controllers
@ComponentScan("ie.cct.*")
public class FarmmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmmanagerApplication.class, args);
	}

}
