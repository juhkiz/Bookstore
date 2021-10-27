package Bookstore.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import Bookstore.Bookstore.domain.Book;
import Bookstore.Bookstore.domain.BookRepository;
import Bookstore.Bookstore.domain.Category;
import Bookstore.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTests {
		
	@Autowired
	private BookRepository bRepository;
	
	@Autowired
	private CategoryRepository cRepository;
	
	@Test
	public void createNewCategory(){
		Category categoryTest = new Category("Scifi");
		cRepository.save(categoryTest); //save luo categoryTest categorialle id:n jota voidaan testata alla
		assertThat(categoryTest.getCategoryid()).isNotNull();
	}
	
	@Test
	public void createNewBook(){
		Book bookTest = new Book("Test1", "Testaaja", 2001, "TESTI123", 12.43, new Category("Testi"));
		bRepository.save(bookTest); // save luo bookTest kirjalle id:n, jolloin sitä voidaan testata alla
		assertThat(bookTest.getId()).isNotNull();
	}
	
	@Test
	public void findCategory() {
		List<Category> categs = cRepository.findByName("Scifi"); //etsii categorian nimen mukaan, tässä tapauksessa Scifi
		assertThat(categs).hasSize(1);
	}
	
	@Test
	public void findBook() {
		List<Book> books = bRepository.findByTitle("Kirja1"); //etsii kirjan nimen mukaan, tässä tapauksessa Kirja1
		assertThat(books).hasSize(1);
	}
	
	@Test
	public void deleteBook() {
		Book bookTest = new Book("Test1", "Testaaja", 2001, "TESTI123", 12.43, new Category("Testi"));
		bRepository.save(bookTest);
		long testId = bookTest.getId();
		assertThat(bookTest.getId()).isNotNull();
		bRepository.deleteById(bookTest.getId());
		assertThat(bRepository.findById(testId).equals(null)); // lisätään ensin kirja, ja tallennetaan sille id arvo. Tämän jälkeen testataan että kyseisellä kirjalla on id.
																// Sitten kirja poistetaan kyseistä id:tä käyttämällä ja testataan vielä, että palauttaako kyseinen id null arvon -> kirja poistunut
	}
	
	@Test
	public void deleteCategory() {
		Category categTest = new Category("CategTesti");
		cRepository.save(categTest);
		long testId = categTest.getCategoryid();
		assertThat(categTest.getCategoryid()).isNotNull();
		cRepository.deleteById(categTest.getCategoryid());
		assertThat(cRepository.findById(testId).equals(null)); 
	}
}
