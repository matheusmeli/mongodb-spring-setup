package br.com.mercadolivre.mongodbtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MongodbTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MongodbTestApplication.class, args);
	}

	@Autowired
	private CustomerRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		List<Customer> customers = repository.findAll();
		customers.forEach(System.out::println);

		repository.save(new Customer("Matheus", "Gomes"));
		repository.save(new Customer("Cebolinha", "da Turma da Monica"));

		repository.findAll().forEach(System.out::println);
	}
}
