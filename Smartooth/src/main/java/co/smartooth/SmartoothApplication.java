package co.smartooth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.smartooth"})
public class SmartoothApplication extends SpringBootServletInitializer{

	//	WAR 패키징 할 때 유의사항
	// @SpringBootApplication에 SpringBootServletInitializer 상속 받아서 configure 오버라이드 해야함
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(SmartoothApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SmartoothApplication.class, args);
	}

}
