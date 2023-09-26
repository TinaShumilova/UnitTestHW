package lv.gb.unittest.hw4;

import java.util.List;

public interface BookRepository {
    Book findById(String id);
    List<Book> findAll();
    void addBooks(String id, Book book);
}
