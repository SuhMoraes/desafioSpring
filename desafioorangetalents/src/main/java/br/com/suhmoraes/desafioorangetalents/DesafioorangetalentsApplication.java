package br.com.suhmoraes.desafioorangetalents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafioorangetalentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioorangetalentsApplication.class, args);
	}

}
