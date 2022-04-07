package br.edu.infnet.atnuvem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AtnuvemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtnuvemApplication.class, args);
	}

}
