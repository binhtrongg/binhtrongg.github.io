package com.example.book_management.service;
import com.example.book_management.model.BookBorrowing;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookBorrowingService {
    static final List<BookBorrowing> bookBorrowings = new ArrayList<>();
    static int auto_id=10000;

    public List<BookBorrowing> getBookBorrowings() {
        return bookBorrowings;
    }

    public void saveBookBorrow(BookBorrowing bookBorrowing) {
        ++auto_id;
        bookBorrowing.setId(auto_id);
        bookBorrowings.add(bookBorrowing);
    }
}
