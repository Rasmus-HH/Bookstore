package hh.fi.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hh.fi.Bookstore.domain.Book;
import hh.fi.Bookstore.domain.BookRepository;
import hh.fi.Bookstore.domain.Category;
import hh.fi.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookTest(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("Tallenetaan pari kirjaa (testi)");
			Category category1 = new Category("Scifi");
			crepository.save(category1);
			Category category2 = new Category("Comic");
			crepository.save(category2);
			Category category3 = new Category("Thriller");
			crepository.save(category3);
			
			repository.save(new Book("Kirjailia kirjanen", "Kirjanen", "1553343-323", "1990", category1));
			repository.save(new Book("Dan Brown", "Suuri mysteeri", "5322445-324", "2003", category3));
			repository.save(new Book("Dan Brown", "pieni mysteeri", "5322445-323", "2002", category3));
			repository.save(new Book("Testi123", "kirja", "532212345-323", "2030", category2));
			
			log.info("Kirjat: ");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}