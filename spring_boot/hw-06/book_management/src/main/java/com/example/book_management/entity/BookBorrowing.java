package com.example.book_management.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookBorrowing {
    int id;
    Reader reader;
    Book book;
    int numOfDays;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dob;
}
