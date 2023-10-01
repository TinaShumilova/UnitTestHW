import lv.gb.unittest.hw4.Book;
import lv.gb.unittest.hw4.BookRepository;
import lv.gb.unittest.hw4.BookService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class BookServiceTest {
    @Test
    public void testBokServiceFindByID() {

        BookRepository mockBookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(mockBookRepository);
        when(bookService.findBookById("3")).thenReturn(new Book("3", "Book3", "Author3"));
        bookService.findBookById("3");
        assertEquals(bookService.findBookById("3").getInfo(), "Book id: 3, title: Book3, author: Author3");
    }
    @Test
    public void testBokServiceFindALL() {

        BookRepository mockBookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(mockBookRepository);
        ArrayList<Book> books = new ArrayList<>();
//        books.add(new Book("1", "Book1", "Author1"));
//        books.add(new Book("2", "Book2", "Author2"));
        when(bookService.findAllBooks()).thenReturn(books);
        bookService.findAllBooks();
        verify(mockBookRepository, times(1)).findAll();
    }
}
