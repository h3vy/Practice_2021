package books.storage;

import books.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BooksStorage {
    private static int BOOK_COUNT;
    ArrayList<Book> booksList;

    { // Блок инициализации
        booksList = new ArrayList<>();

        booksList.add(new Book(++BOOK_COUNT,"Book_1","Author_1"));
        booksList.add(new Book(++BOOK_COUNT,"Book_2","Author_2"));
        booksList.add(new Book(++BOOK_COUNT,"Book_3","Author_3"));
    }

    public List<Book> index(){
        return booksList;
    }

    public Book show(int id){
        return booksList.stream().filter(book -> book.getId() == id).findAny().orElse(null);
    }

    public void save(Book book){
        book.setId(++BOOK_COUNT);
        booksList.add(book);
    }

    public void delete(int id) {
        booksList.removeIf(p -> p.getId() == id);
    }
}
