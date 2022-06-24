package com.platzi.springboot.fundamentos;

import com.platzi.springboot.fundamentos.component.MyFirstComponent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private MyFirstComponent myFirstComponent;

	public FundamentosApplication(MyFirstComponent myFirstComponent) {
	this.myFirstComponent = myFirstComponent;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
		System.out.println();
	}


	@Override
	public void run(String... args) throws Exception {
		myFirstComponent.sayHello();
	}
}
