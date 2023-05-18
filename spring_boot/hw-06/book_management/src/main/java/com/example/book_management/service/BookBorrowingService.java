package com.example.book_management.service;

import com.example.book_management.entity.Book;
import com.example.book_management.entity.BookBorrowing;
import com.example.book_management.entity.Reader;
import com.example.book_management.model.BookBorrowingModel;
import com.example.book_management.model.BookModel;
import com.example.book_management.model.ReaderModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookBorrowingService {
    ObjectMapper objectMapper;
    static final List<BookBorrowing> bookBorrowings = new ArrayList<>();
    static int auto_id = 10000;

    public List<BookBorrowingModel> getBookBorrowings() {
        List<BookBorrowingModel> bookBorrowingModels = new ArrayList<>();
        for (BookBorrowing b : bookBorrowings) {
            BookBorrowingModel bookBorrowingModel = new BookBorrowingModel();
            bookBorrowingModel.setId(b.getId());
            bookBorrowingModel.setReaderModel(objectMapper.convertValue(b.getReader(), ReaderModel.class));
            bookBorrowingModel.setBookModel(objectMapper.convertValue(b.getBook(), BookModel.class));
            bookBorrowingModel.setNumOfDays(b.getNumOfDays());
            bookBorrowingModel.setDob(b.getDob());
            bookBorrowingModels.add(bookBorrowingModel);
        }
        return bookBorrowingModels;
    }

    public void saveBookBorrow(BookBorrowingModel bookBorrowingModel) {
        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBook(objectMapper.convertValue(bookBorrowingModel.getBookModel(), Book.class));
        bookBorrowing.setReader(objectMapper.convertValue(bookBorrowingModel.getReaderModel(), Reader.class));
        bookBorrowing.setNumOfDays(bookBorrowingModel.getNumOfDays());
        bookBorrowing.setDob(bookBorrowingModel.getDob());
        ++auto_id;
        bookBorrowing.setId(auto_id);
        bookBorrowings.add(bookBorrowing);
    }

    public BookBorrowingModel findById(int id) {
        Optional<BookBorrowing> bookBorrowingOptional = bookBorrowings.stream()
                .filter(bookBorrowing -> bookBorrowing.getId() == id)
                .findFirst();
        if (bookBorrowingOptional.isEmpty()) {
            return null;
        }
        BookBorrowing bookBorrowing = bookBorrowingOptional.get();

        BookBorrowingModel bookBorrowingModel = new BookBorrowingModel();
        bookBorrowingModel.setId(bookBorrowing.getId());
        bookBorrowingModel.setReaderModel(objectMapper.convertValue(bookBorrowing.getReader(), ReaderModel.class));
        bookBorrowingModel.setBookModel(objectMapper.convertValue(bookBorrowing.getBook(), BookModel.class));
        bookBorrowingModel.setNumOfDays(bookBorrowing.getNumOfDays());
        bookBorrowingModel.setDob(bookBorrowing.getDob());

        return bookBorrowingModel;
    }


    public void updateBookborrowing(BookBorrowingModel bookBorrowingModelUpdate) {
        bookBorrowings.forEach(bookBorrowing -> {
            if (bookBorrowing.getId() != bookBorrowingModelUpdate.getId()) {
                return;
            }
            bookBorrowing.setBook(objectMapper.convertValue(bookBorrowingModelUpdate.getBookModel(), Book.class));
            bookBorrowing.setReader(objectMapper.convertValue(bookBorrowingModelUpdate.getReaderModel(), Reader.class));
            bookBorrowing.setNumOfDays(bookBorrowingModelUpdate.getNumOfDays());
            bookBorrowing.setDob(bookBorrowingModelUpdate.getDob());
        });
    }


    public void deleteBorrow(int id) {
        bookBorrowings.removeIf(bookBorrowingModel -> bookBorrowingModel.getId() == id);
    }
}
