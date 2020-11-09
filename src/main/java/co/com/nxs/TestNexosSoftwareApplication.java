package co.com.nxs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync 
public class TestNexosSoftwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestNexosSoftwareApplication.class, args);
	} 

}
