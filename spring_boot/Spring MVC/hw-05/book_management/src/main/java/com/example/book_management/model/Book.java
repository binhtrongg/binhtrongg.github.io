package com.example.book_management.model;
import com.example.book_management.statics.BookType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    static int auto_id=10000;
    int id;
    String name;
    String author;
    BookType bookType;
    int creationYear;
}
