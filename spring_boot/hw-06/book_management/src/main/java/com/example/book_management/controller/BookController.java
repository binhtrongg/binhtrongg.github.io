package com.example.book_management.controller;

import com.example.book_management.model.BookModel;
import com.example.book_management.service.BookService;
import com.example.book_management.statics.BookState;
import com.example.book_management.statics.BookType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {
    BookService bookService;

    @GetMapping
    public String showBookList(Model model) {
        List<BookModel> bookModels = bookService.getBooks();
        model.addAttribute("dsBook", bookModels);
        model.addAttribute("bookTypes", BookType.values());
        model.addAttribute("bookStates", BookState.values());
        return "list-book";
    }

    @PostMapping("/add-book")
    public String addBook(@ModelAttribute("newBook") @Valid BookModel bookModel, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bookTypes", BookType.values());
            return "creat-book"; // Chuyển đến trang tạo sách nếu có lỗi
        } else {
            bookService.saveBook(bookModel);
            return "redirect:/books"; // Chuyển đến trang danh sách sách sau khi thêm sách thành công
        }
    }

    @PostMapping("/update-book/{id}")
    public String updateBook(@ModelAttribute("book") BookModel updateBookModel) {
        bookService.updateBook(updateBookModel);
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    //
    @GetMapping("/create-form")
    public String forwardToCreateForm(Model model, BookModel bookModel) {
        model.addAttribute("newBook", bookModel);
        model.addAttribute("bookTypes",BookType.values());
        return "creat-book";
    }
//
}
