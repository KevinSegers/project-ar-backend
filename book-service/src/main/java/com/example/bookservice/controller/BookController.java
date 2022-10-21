package com.example.bookservice.controller;

import com.example.bookservice.model.Book;
import com.example.bookservice.model.Category;
import com.example.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostConstruct
    public void fillDB() {
        if (bookRepository.count() == 0) {
            bookRepository.save(new Book("Nijntje in de speeltuin","Dick Bruna", Category.Nijntje, false, true, "https://i.postimg.cc/RFrDZ6zc/Nijntjeindespeeltuin.jpg", "https://i.postimg.cc/8cm3319L/Nijntjeindespeeltuinachterkant.jpg"));
            bookRepository.save(new Book("Nijntje","Dick Bruna", Category.Nijntje, false,false, "https://i.postimg.cc/m2VJygQs/Nijntje.jpg", "https://i.postimg.cc/FHRqWXZJ/Nijntjeachterkant.jpg"));
            bookRepository.save(new Book("Nijntje in de dierentuin","Dick Bruna", Category.Nijntje, false,false, "https://i.postimg.cc/Gm5f6g7g/Nijntjeindedierentuin.jpg", "https://i.postimg.cc/65BFZv4c/Nijntjeindedierentuinachterkant.jpg"));
            bookRepository.save(new Book("Samen spelen samen delen","Gert Verhulst", Category.Bumba, false,false,"https://i.postimg.cc/rww6Br8s/Bumbasamenspelensamendelen.jpg", "https://i.postimg.cc/L8Qd28XT/Bumbasamenspelensamendelenachterkant.jpg"));
            bookRepository.save(new Book("Ik ruim op dat is top","Gert Verhulst", Category.Bumba, false,false, "https://i.postimg.cc/bN8fR5WQ/Bumbaikruimopdatistop.jpg", "https://i.postimg.cc/dtBPNBcg/Bumbaikruimopdatistopachterkant.jpg"));
            bookRepository.save(new Book("Boe doet de koe","Gert Verhulst", Category.Bumba, false,false, "https://i.postimg.cc/bJBdnh3H/Bumbaboedoetdekoe.jpg", "https://i.postimg.cc/W4dB3cqP/Bumbaboedoetdekoeachterkant.jpg" ));
            bookRepository.save(new Book("Dribbel naar de boerderij","Eric Hill", Category.Dribbel, false,false, "https://i.postimg.cc/MZ7hXDHX/Dribbelnaardeboerderij.jpg", "https://i.postimg.cc/d3Yp47Hq/Dribbelnaardeboerderijachterkant.jpg"));
            bookRepository.save(new Book("Dribbel naar de bij opa en oma","Eric Hill", Category.Dribbel, false,false, "https://i.postimg.cc/QNcr1D48/Dribbelbijopaenoma.jpg", "https://i.postimg.cc/qqcVTchh/dribbelbijopaenomaachterkant.jpg"));
            bookRepository.save(new Book("Dribbel naar het ziekenhuis","Eric Hill", Category.Dribbel, false,false, "https://i.postimg.cc/W3rxGm7W/Dribbelnaarhetziekenhuis.jpg", "https://i.postimg.cc/43jrH2pH/Dribbelnaarhetziekenhuisachterkant.jpg"));

            System.out.println("Books added to database");
            }
    }

    @GetMapping("/books/title/{title}")
    public Book getItemByName(@PathVariable String title){
        return bookRepository.findBookByTitle(title);
    }

    @GetMapping("/books/category/{category}")
    public List<Book> getBookByCategory(@PathVariable Category category){
        return bookRepository.findBooksByCategory(category);
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){

        bookRepository.save(book);

        return book;
    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book updatedBook){
        Book retrievedBook = bookRepository.findBookById(updatedBook.getId());
        retrievedBook.setAuthor(updatedBook.getAuthor());
        retrievedBook.setTitle(updatedBook.getTitle());
        retrievedBook.setCategory(updatedBook.getCategory());
        retrievedBook.setAvailable(updatedBook.isAvailable());
        retrievedBook.setFavorite(updatedBook.isFavorite());
        bookRepository.save(retrievedBook);

        return retrievedBook;
    }

    @DeleteMapping("/books/{booktTitle}")
    public ResponseEntity deleteBook(@PathVariable String booktTitle){
        Book book = bookRepository.findBookByTitle(booktTitle);
        if(book!=null){
            bookRepository.delete(book);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }




}
