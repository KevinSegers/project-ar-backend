package com.example.bookservice.repository;

import com.example.bookservice.model.Book;
import com.example.bookservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    Book findBookByTitle(String title);
    Book findBookById(int id);
    List<Book> findBooksByCategory(Category category);
}
