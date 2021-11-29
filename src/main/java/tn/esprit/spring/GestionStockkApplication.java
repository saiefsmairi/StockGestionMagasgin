package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EntityScan( basePackages = {"tn.esprit.entity"} )
@ComponentScan("tn.esprit")
@EnableSwagger2
@EnableScheduling
@SpringBootApplication
@EnableAspectJAutoProxy
public class GestionStockkApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionStockkApplication.class, args);
	}

}
