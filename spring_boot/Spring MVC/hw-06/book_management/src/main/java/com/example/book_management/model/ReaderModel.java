package com.example.book_management.model;

import com.example.book_management.statics.ReaderType;
import lombok.*;
import lombok.experimental.FieldDefaults;
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReaderModel extends Person{
    int id;
    ReaderType readerType;
    public ReaderModel(int id, String name, String address, String phoneNumber, ReaderType readerType) {
        super(name, address, phoneNumber);
        this.id = id;
        this.readerType = readerType;
    }
}
