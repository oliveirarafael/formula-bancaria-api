package br.com.formula.bancaria.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport
//@EnableCaching
@EnableSwagger2
public class FormulaBancariaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormulaBancariaApiApplication.class, args);
	}

}
