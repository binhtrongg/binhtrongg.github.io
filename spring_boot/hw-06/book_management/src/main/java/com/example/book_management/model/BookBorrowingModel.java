package com.example.book_management.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookBorrowingModel {
    int id;
    ReaderModel readerModel;
    BookModel bookModel;
    int numOfDays;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dob;

    public BookBorrowingModel(ReaderModel readerModel, BookModel bookModel, int numOfDays, LocalDate dob) {
        this.readerModel = readerModel;
        this.bookModel = bookModel;
        this.numOfDays = numOfDays;
        this.dob = dob;
    }
}
