package com.example.book_management.service;
import com.example.book_management.model.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    static int autoId=10000;
    private static final List<Book>books=new ArrayList<>();

    public void saveBook(Book book) {
        ++autoId;
        book.setId(autoId);
        books.add(book);
    }
    public List<Book> getBooks(){
        return books;
    }

    public Book getBookById(int id){
        for (Book book:books) {
            if (book.getId()==id){
                return book;
            }
        }
        return null;
    }

    public void updateBook(int id,Book updateBook) {
        Book myBook=getBookById(id);
        myBook.setName(updateBook.getName());
        myBook.setAuthor(updateBook.getAuthor());
        myBook.setBookType(updateBook.getBookType());
        myBook.setCreationYear(updateBook.getCreationYear());
    }
}
