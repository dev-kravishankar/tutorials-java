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

/**
 * @author ravis
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestSpringBootJPAApp.class)
public class AuthorRepositoryTest {
	@Autowired
	AuthorRepository authorRepository;

	@Before
	public void before() {
		System.out.println("*********************************");
		insertTestData();
	}

	private void insertTestData() {
		Author author1 = new Author("Romila", "Thapar");
		Author author2 = new Author("Coomi", "Kapoor");
		Author author3 = new Author("Narsimha", "Pamulaparti");

		authorRepository.save(author1);
		authorRepository.save(author2);
		authorRepository.save(author3);
	}

	/**
	 * Test method for
	 * {@link com.krs.tutorials.rest.springboot.jpa.repository.AuthorRepository#findByFirstNameContaining(java.lang.String)}.
	 */
	@Test
	public void testFindByFirstNameContaining() {

		List<Author> authors = authorRepository.findByFirstNameContaining("o");
		assertEquals(2, authors.size());

		assertEquals(authors.get(0).getFirstName(), "Romila");
		assertEquals(authors.get(1).getFirstName(), "Coomi");
	}

	/**
	 * Test method for
	 * {@link com.krs.tutorials.rest.springboot.jpa.repository.AuthorRepository#findByFirstNameOrLastName(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testFindByFirstNameOrLastName() {
		List<Author> authors = authorRepository.findByFirstNameOrLastName("Romila", "Pamulaparti");
		assertEquals(2, authors.size());
		assertEquals(authors.get(0).getLastName(), "Thapar");
		assertEquals(authors.get(1).getFirstName(), "Narsimha");

	}

	/**
	 * Test method for
	 * {@link com.krs.tutorials.rest.springboot.jpa.repository.AuthorRepository#findByFirstNameContainingOrLastNameContaining(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testFindByFirstNameContainingOrLastNameContaining() {
		List<Author> authors = authorRepository.findByFirstNameContainingOrLastNameContaining("l", "P");
		assertEquals(2, authors.size());
		assertEquals(authors.get(0).getLastName(), "Thapar");
		assertEquals(authors.get(1).getFirstName(), "Narsimha");
	}

	@After
	public void tearDown() throws Exception {
		authorRepository.deleteAll();
	}

}
