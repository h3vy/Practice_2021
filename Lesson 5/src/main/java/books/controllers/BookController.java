package books.controllers;


import books.models.Book;
import books.storage.BooksStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/booksStorage")
public class BookController {

    private final BooksStorage booksStorage;

    @Autowired
    public BookController(BooksStorage booksStorage) {
        this.booksStorage = booksStorage;
    }

    @GetMapping() // Адрес пустой т.к. мы изначально будем в booksStorage
    public String index(Model model){
        model.addAttribute("booksList", booksStorage.index());
        return "booksStorage/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("Book",booksStorage.show(id));
        return "booksStorage/show";
    }

    @GetMapping("/new")
    public String newBook(Model model){
        model.addAttribute("Book", new Book());
        return "booksStorage/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("Book") Book book ){
        booksStorage.save(book);
        return "redirect:/booksStorage";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        booksStorage.delete(id);
        return "redirect:/booksStorage";
    }


}
