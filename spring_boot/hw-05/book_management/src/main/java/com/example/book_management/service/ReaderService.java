package com.example.book_management.service;

import com.example.book_management.model.Book;
import com.example.book_management.model.Reader;
import com.example.book_management.statics.ReaderType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReaderService {
    static int auto_id=10000;
    private static final List<Reader> readers=new ArrayList<>();

    public List<Reader> getReaders(){
        return readers;
    }

    public void saveReader(Reader reader) {
        ++auto_id;
        reader.setId(auto_id);
        readers.add(reader);
    }

    public Reader getReaderById(int id){
        for (Reader reader:readers) {
            if (reader.getId()==id){
                return reader;
            }
        }
        return null;
    }

    public void updateReader(int id, Reader updateReader) {
        Reader reader=getReaderById(id);
        reader.setName(updateReader.getName());
        reader.setAddress(updateReader.getAddress());
        reader.setPhoneNumber(updateReader.getPhoneNumber());
        reader.setReaderType(updateReader.getReaderType());
    }
}
