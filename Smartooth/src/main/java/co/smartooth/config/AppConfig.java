package co.smartooth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ DBConfig.class, MybatisConfig.class })
public class AppConfig {
	
}