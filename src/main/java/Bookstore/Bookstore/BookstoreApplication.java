package Bookstore.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Bookstore.Bookstore.domain.Book;
import Bookstore.Bookstore.domain.BookRepository;
import Bookstore.Bookstore.domain.Category;
import Bookstore.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDataDemo(BookRepository repository, CategoryRepository categoryRepository ) {
		return (args) -> {
			log.info("Save books and categories for sampledata");
			Category category1 = new Category("Scifi");
			categoryRepository.save(category1);
			Category category2 = new Category("Cartoon");
			categoryRepository.save(category2);

			
			repository.save(new Book("Kirja1", "Juho", 1994, "FI123", 12.43, category1));
			repository.save(new Book("Kirja2", "Pegi", 2000, "FI124", 20.20, category2));

			
			log.info("fetch all books");
			for (Book book : repository.findAll())
			{
				log.info(book.toString());
			}
		};
	}
}
