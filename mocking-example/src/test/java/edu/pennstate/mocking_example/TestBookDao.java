package edu.pennstate.mocking_example;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestBookDao {
	public BookDao mockedBookDao;
	public Book book1;
	public Book book2;
	
	@Before
	public void setup() {
		mockedBookDao = Mockito.mock(BookDao.class);

		// Create few instances of Book class.
		book1 = new Book("8131721019", "Compilers Principles");
		book2 = new Book("9788183331630", "Let Us C 13th Edition");
		Mockito.when(mockedBookDao.getBook("8131721019")).thenReturn(book1);
		Mockito.when(mockedBookDao.getBook("8131721019111")).thenReturn(null);
	}	
	
	@Test
	public void getBookWithAGoodIsbnShouldReturnAGoodBook(){
		Book myBook = mockedBookDao.getBook("8131721019");
		assertEquals("Compilers Principles", myBook.getTitle());
	}
	
	@Test
	public void getBookShouldReturnACorrectTitle(){
		Book myBook = mockedBookDao.getBook("8131721019111");
		assertNull(null, myBook);
	}

}
