package com.example.book_management.service;
import com.example.book_management.model.Book;
import com.example.book_management.model.BookBorrowing;
import com.example.book_management.model.BookBorrowingDetail;
import com.example.book_management.model.Reader;
import com.example.book_management.statics.BookType;
import com.example.book_management.statics.ReaderType;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookBorrowingService {
    static final List<BookBorrowing> bookBorrowings = new ArrayList<>();
    List<BookBorrowingDetail> bookBorrowingDetails=new ArrayList<>();
    static int auto_id=10000;

    public List<BookBorrowing> getBookBorrowings() {
        creatData();
        return bookBorrowings;
    }
    public void saveBookBorrow(BookBorrowing bookBorrowing) {
        ++auto_id;
        bookBorrowing.setId(auto_id);
        bookBorrowings.add(bookBorrowing);
    }
    public void creatData(){
        for (int i = 0; i <5 ; i++) {
            Reader reader=new Reader(i,"van","van","van",ReaderType.GRADUTE_STUDENT);
            Book book=new Book(i,"cd","cds",BookType.Electronics_Telecommunication,i);
            BookBorrowingDetail bookBorrowingDetail=new BookBorrowingDetail(book,i);;
            bookBorrowingDetails.add(bookBorrowingDetail);
            BookBorrowing bookBorrowing=new BookBorrowing(i,reader,bookBorrowingDetails);
            bookBorrowings.add(bookBorrowing);
        }
    }
}
