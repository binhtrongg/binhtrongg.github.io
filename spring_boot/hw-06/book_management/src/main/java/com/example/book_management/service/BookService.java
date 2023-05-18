package com.example.book_management.service;
import com.example.book_management.entity.Book;
import com.example.book_management.model.BookModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookService {
    static int autoId=10000;
    private static final List<Book> books =new ArrayList<>();

    ObjectMapper objectMapper;

    public void saveBook(BookModel bookModel) {
        Book book=objectMapper.convertValue(bookModel,Book.class);
        ++autoId;
        book.setId(autoId);
        books.add(book);
    }
    public List<BookModel> getBooks(){
        List<BookModel> bookModels=new ArrayList<>();
        for (Book book:books) {
            BookModel bookModel=objectMapper.convertValue(book,BookModel.class);
            bookModels.add(bookModel);
        }
        return bookModels;
    }

    public BookModel getBookById(int id){
        Optional<Book>bookOptional=books.stream().filter(book -> book.getId()==id).findFirst();
        if (bookOptional.isEmpty()){
            return null;
        }
        Book book=bookOptional.get();
        return objectMapper.convertValue(book,BookModel.class);
    }

    public void updateBook(BookModel updateBookModel) {
        books.forEach(book -> {
            if (book.getId()!=updateBookModel.getId()){
                return;
            }
            book.setName(updateBookModel.getName());
            book.setAuthor(updateBookModel.getAuthor());
            book.setBookType(updateBookModel.getBookType());
            book.setCreationYear(updateBookModel.getCreationYear());
        });
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.getId()==id);
    }
}
