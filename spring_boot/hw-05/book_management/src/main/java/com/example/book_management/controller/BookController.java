package com.example.book_management.controller;

import com.example.book_management.model.Book;
import com.example.book_management.service.BookService;
import com.example.book_management.statics.BookType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {
    BookService bookService;

    @GetMapping
    public String showBookList(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("dsBook", books);
        model.addAttribute("bookTypes", BookType.values());
        model.addAttribute("book",new Book());
        return "list-book";
    }
    @PostMapping("/add-book")
    public String addBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @PostMapping("/update-book/{id}")
    public String updateBook(@PathVariable("id") int id, @ModelAttribute("book") Book updateBook) {
        bookService.updateBook(id,updateBook);
        return "redirect:/books";
    }
}
