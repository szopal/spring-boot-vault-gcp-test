package com.test.spring.testapp;

import com.test.spring.testapp.dto.TestTable;
import com.test.spring.testapp.repository.TestTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TestAppApplication implements CommandLineRunner {

	@Autowired
	private TestTableRepository testTableRepository;


	public static void main(String[] args) {
		SpringApplication.run(TestAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<TestTable> result = testTableRepository.findAll();
		System.out.println("Result" + result);
	}


}
