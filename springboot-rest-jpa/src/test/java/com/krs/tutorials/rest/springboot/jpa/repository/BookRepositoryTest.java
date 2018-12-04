/**
 * 
 */
package com.krs.tutorials.rest.springboot.jpa.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.krs.tutorials.rest.springboot.jpa.RestSpringBootJPAApp;
import com.krs.tutorials.rest.springboot.jpa.model.Author;
import com.krs.tutorials.rest.springboot.jpa.model.Book;

/**
 * @author ravis
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestSpringBootJPAApp.class)
public class BookRepositoryTest {

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	BookRepository bookRepository;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		insertData();
	}

	private void insertData() {
		Author author1 = new Author("Romila", "Thapar");
		Author author2 = new Author("Coomi", "Kapoor");
		Author author3 = new Author("Narsimha", "Pamulaparti");

		author1 = authorRepository.save(author1);
		author2 = authorRepository.save(author2);
		author3 = authorRepository.save(author3);

		Book book1 = new Book();
		book1.setName("A History of India");
		book1.setAuthor(author1);
		bookRepository.save(book1);

		Book book2 = new Book();
		book2.setName("Insider");
		book2.setAuthor(author3);
		bookRepository.save(book2);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		bookRepository.deleteAll();
		authorRepository.deleteAll();
	}

	/**
	 * Test method for
	 * {@link org.springframework.data.jpa.repository.JpaRepository#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<Book> books = bookRepository.findAll();
		assertEquals(2, books.size());
	}

}
