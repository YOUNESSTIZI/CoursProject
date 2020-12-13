package coursdiscoveryserverapplication.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // Activate Eureka Server then provide application propreties
public class CoursDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursDiscoveryServerApplication.class, args);
	}

}
