package com.example.book_management.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookBorrowing {
    int id;
    Reader reader;
    List<BookBorrowingDetail>bookBorrowingDetails;
}
