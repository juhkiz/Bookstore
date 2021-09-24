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
			repository.save(new Book("Kirja1", "Juho", 1994, "FI123", 12.43));
			repository.save(new Book("Kirja2", "Pegi", 2000, "FI124", 20.20));
			categoryRepository.save(new Category("Scifi"));
			categoryRepository.save(new Category("Comic"));
			
			log.info("fetch all books");
			for (Book book : repository.findAll())
			{
				log.info(book.toString());
			}
			log.info("fetch all categories");
			for (Category category: categoryRepository.findAll())
			{
				log.info(category.toString());
			}
		};
	}
}
