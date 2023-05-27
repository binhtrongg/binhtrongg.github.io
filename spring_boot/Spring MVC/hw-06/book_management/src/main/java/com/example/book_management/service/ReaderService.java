package com.example.book_management.service;

import com.example.book_management.entity.Book;
import com.example.book_management.entity.Reader;
import com.example.book_management.model.BookModel;
import com.example.book_management.model.ReaderModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ReaderService {
    ObjectMapper objectMapper;
    static int auto_id=10000;
    private static final List<Reader> readers =new ArrayList<>();

    public List<ReaderModel> getReaders(){
        List<ReaderModel>readerModels=new ArrayList<>();
        for (Reader reader:readers) {
            ReaderModel readerModel=objectMapper.convertValue(reader,ReaderModel.class);
            readerModels.add(readerModel);
        }
        return readerModels;
    }

    public void saveReader(ReaderModel readerModel) {
        Reader reader=objectMapper.convertValue(readerModel,Reader.class);
        ++auto_id;
        reader.setId(auto_id);
        readers.add(reader);
    }

    public ReaderModel getReaderById(int id){
        Optional<Reader> readerOptional=readers.stream().filter(reader -> reader.getId()==id).findFirst();
        if (readerOptional.isEmpty()){
            return null;
        }
        Reader reader=readerOptional.get();
        return objectMapper.convertValue(reader, ReaderModel.class);
    }

    public void updateReader(ReaderModel updateReaderModel) {
        readers.forEach(reader -> {
            if (reader.getId()!=updateReaderModel.getId()){
                return;
            }
            reader.setName(updateReaderModel.getName());
            reader.setAddress(updateReaderModel.getAddress());
            reader.setPhoneNumber(updateReaderModel.getPhoneNumber());
            reader.setReaderType(updateReaderModel.getReaderType());
        });
    }

    public void deleteReader(int id) {
        readers.removeIf(readerModel -> readerModel.getId()==id);
    }
}
