package com.example.book_management.controller;
import com.example.book_management.model.BookBorrowingModel;
import com.example.book_management.model.BookModel;
import com.example.book_management.model.ReaderModel;
import com.example.book_management.service.BookBorrowingService;
import com.example.book_management.service.BookService;
import com.example.book_management.service.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
        List<BookBorrowingModel> bookBorrowingModels =bookBorrowingService.getBookBorrowings();
        model.addAttribute("dsBookBorrowing", bookBorrowingModels);
        model.addAttribute("readers", readerService.getReaders());
        model.addAttribute("books", bookService.getBooks());
        model.addAttribute("bookBorrowing", new BookBorrowingModel());
        return "muonsach-form";
    }

    @PostMapping("/addNewBorrow")
    public String addBookBorrow(@RequestParam("readerModel") int readerId,
                                @RequestParam("bookModel") int bookId,
                                @RequestParam("numOfDays") int numOfDays) {
        ReaderModel readerModel =readerService.getReaderById(readerId);
        BookModel bookModel =bookService.getBookById(bookId);
        BookBorrowingModel bookBorrowingModel =new BookBorrowingModel(readerModel, bookModel,numOfDays);
        bookBorrowingService.saveBookBorrow(bookBorrowingModel);
        return "redirect:/borrow-book";
    }
    @PostMapping("/update-borrow/{id}")
    public String updateBookBorrow(@PathVariable("id") int id,
                                   @RequestParam("readerModel") int readerId,
                                   @RequestParam("bookModel") int bookId,
                                   @RequestParam("numOfDays") int numOfDays) {
        ReaderModel readerModel = readerService.getReaderById(readerId);
        BookModel bookModel = bookService.getBookById(bookId);
        BookBorrowingModel bookBorrowingModel = bookBorrowingService.findById(id);

        if (bookBorrowingModel != null) {
            bookBorrowingModel.setReaderModel(readerModel);
            bookBorrowingModel.setBookModel(bookModel);
            bookBorrowingModel.setNumOfDays(numOfDays);
            bookBorrowingService.updateBookborrowing(bookBorrowingModel);
        }

        return "redirect:/borrow-book";
    }

}
