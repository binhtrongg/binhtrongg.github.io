package com.example.book_management.model;

import com.example.book_management.statics.BookType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookModel {
    static int auto_id = 10000;

    int id;

    @Size(max = 100,message ="Tên Sách Không Vượt Quá 100 Kí Tự" )
    @NotBlank(message = "Tên Sách Không Được Để Trống")
    String name;

    @Size(max = 100,message ="Tên Tác Giả Không Vượt Quá 100 Kí Tự" )
    @NotEmpty(message = "Tên Tác Giả Không Được Để Trống")
    String author;

    @NotNull(message = "Loại Sách Không Được Trống")
    BookType bookType;

    @NotNull(message = "Năm Sáng Tác Không Được Trống")
    @Min(value = 0, message = "Năm Sáng Tác Phải Lớn Hơn Hoặc Bằng 0")
    int creationYear;
}
