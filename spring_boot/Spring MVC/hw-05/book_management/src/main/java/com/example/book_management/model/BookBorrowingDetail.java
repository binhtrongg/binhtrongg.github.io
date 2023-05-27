package com.example.book_management.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookBorrowingDetail {
    Book book;
    int numOfDays;
}
