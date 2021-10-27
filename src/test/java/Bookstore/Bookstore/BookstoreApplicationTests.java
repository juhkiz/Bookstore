package Bookstore.Bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import Bookstore.Bookstore.web.BookController;

@ExtendWith(SpringExtension.class) //<- Jupiter
@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private BookController bookController;
	

	@Test
	void contextLoads() {
		assertThat(bookController).isNotNull(); //Smoke testingissä testataan vain ohjelman "suuria linjoja", että ne toimivat ennenkuin testataan yksityiskohtaisemmin
	}

}
