package com.example.book_management.controller;

import com.example.book_management.model.BookBorrowing;
import com.example.book_management.model.Reader;
import com.example.book_management.service.BookBorrowingService;
import com.example.book_management.service.BookService;
import com.example.book_management.service.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/borrow-book")
public class BookBorrowingController {
    BookService bookService;
    ReaderService readerService;
    BookBorrowingService bookBorrowingService;

    @GetMapping
    public String showAddMuonSachForm(Model model) {
        List<BookBorrowing>bookBorrowings=bookBorrowingService.getBookBorrowings();
        model.addAttribute("dsBookBorrowing",bookBorrowings);
        model.addAttribute("readers", readerService.getReaders());
        model.addAttribute("books", bookService.getBooks());
        model.addAttribute("bookBorrowing", new BookBorrowing());
        return "muonsach-form";
    }

    @PostMapping("/addNewBorrow")
    public String addBookBorrow(@ModelAttribute("bookBorrowing") BookBorrowing bookBorrowing) {
        bookBorrowingService.saveBookBorrow(bookBorrowing);
        return "redirect:/borrow-book";
    }
}
