package example;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//Giving informaion in swaagger
@OpenAPIDefinition(
		info=@Info(
				title = "Spring Boot Rest API Documentation",
				description = "Spring Boot Rest API documentation for the service",
				license = @License(
						name="Jayanthi practice"

				),
				contact= @Contact(
						name="Springboot RestFul webservice",
						url="spring boot service ",
						email="jayanthi.ch98@gmail.com"

				),
				version = "1.0.0"
		)
)
@SpringBootApplication
public class SpringBootRestfulWebservicesApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestfulWebservicesApplication.class, args);
	}

}
