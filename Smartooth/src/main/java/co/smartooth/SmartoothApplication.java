package co.smartooth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.smartooth"})
public class SmartoothApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartoothApplication.class, args);
	}

}