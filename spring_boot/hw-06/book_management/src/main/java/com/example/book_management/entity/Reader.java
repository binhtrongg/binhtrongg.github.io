package com.example.book_management.entity;

import com.example.book_management.model.Person;
import com.example.book_management.statics.ReaderType;
import lombok.*;
import lombok.experimental.FieldDefaults;
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reader extends Person {
    int id;
    ReaderType readerType;
    public Reader(int id,String name, String address, String phoneNumber,ReaderType readerType) {
        super(name, address, phoneNumber);
        this.id = id;
        this.readerType = readerType;
    }
}
