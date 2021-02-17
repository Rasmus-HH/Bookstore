package hh.fi.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hh.fi.Bookstore.domain.Book;
import hh.fi.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookTest(BookRepository repository) {
		return (args) -> {
			log.info("Tallenetaan pari kirjaa (testi)");
			repository.save(new Book("Kirjailia kirjanen", "Kirjanen", "1553343-323", "1990"));
			repository.save(new Book("Dan Brown", "Suuri mysteeri", "5322445-324", "2003"));
			repository.save(new Book("Dan Brown", "pieni mysteeri", "5322445-323", "2002"));	
			
			log.info("Kirjat: (toivottavasti)");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}