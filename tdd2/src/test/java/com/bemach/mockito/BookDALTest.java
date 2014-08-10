package com.bemach.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BookDALTest {
	private static BookDAL mockedBookDAL;
	private static Book book1;
	private static Book book2;

	@Before
	public void setUp() {
		// Create mock object of BookDAL
		mockedBookDAL = Mockito.mock(BookDAL.class);

		// Create few instances of Book class.
		book1 = new Book("8131721019", "Compilers Principles", Arrays.asList(
				"D. Jeffrey Ulman", "Ravi Sethi", "Alfred V. Aho",
				"Monica S. Lam"), "Pearson Education Singapore Pte Ltd", 2008,
				1009, "BOOK_IMAGE");

		book2 = new Book("9788183331630", "Let Us C 13th Edition",
				Arrays.asList("Yashavant Kanetkar"), "BPB PUBLICATIONS", 2012,
				675, "BOOK_IMAGE");

		// Stubbing the methods of mocked BookDAL with mocked data.
		Mockito.when(mockedBookDAL.getAllBooks()).thenReturn(
				Arrays.asList(book1, book2));
		Mockito.when(mockedBookDAL.getBook("8131721019")).thenReturn(book1);
		Mockito.when(mockedBookDAL.addBook(book1)).thenReturn(book1.getIsbn());
		Mockito.when(mockedBookDAL.updateBook(book1)).thenReturn(
				book1.getIsbn());

	}

	@Test
	public void testGetAllBooks() throws Exception {

		List<Book> allBooks = mockedBookDAL.getAllBooks();
		assertEquals(2, allBooks.size());
		Book myBook = allBooks.get(0);
		assertEquals("8131721019", myBook.getIsbn());
		assertEquals("Compilers Principles", myBook.getTitle());
		assertEquals(4, myBook.getAuthors().size());
		assertEquals((Integer) 2008, myBook.getYearOfPublication());
		assertEquals((Integer) 1009, myBook.getNumberOfPages());
		assertEquals("Pearson Education Singapore Pte Ltd",
				myBook.getPublication());
		assertEquals("BOOK_IMAGE", myBook.getImage());
	}

	@Test
	public void testGetBook() {

		String isbn = "8131721019";

		Book myBook = mockedBookDAL.getBook(isbn);

		assertNotNull(myBook);
		assertEquals(isbn, myBook.getIsbn());
		assertEquals("Compilers Principles", myBook.getTitle());
		assertEquals(4, myBook.getAuthors().size());
		assertEquals("Pearson Education Singapore Pte Ltd",
				myBook.getPublication());
		assertEquals((Integer) 2008, myBook.getYearOfPublication());
		assertEquals((Integer) 1009, myBook.getNumberOfPages());

	}

	@Test
	public void testAddBook() {
		String isbn = mockedBookDAL.addBook(book1);
		assertNotNull(isbn);
		assertEquals(book1.getIsbn(), isbn);
	}

	@Test
	public void testUpdateBook() {

		String isbn = mockedBookDAL.updateBook(book1);
		assertNotNull(isbn);
		assertEquals(book1.getIsbn(), isbn);
	}
}
