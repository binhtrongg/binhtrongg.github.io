package BookManagement.service;

import BookManagement.model.Book;
import BookManagement.repository.BookRepository;

import java.time.LocalDate;
import java.util.Locale;

public class BookService {
    public void findbytitle(String title) {
        int cout = 0;
        for (Book book : BookRepository.books) {
            if (book.title.toLowerCase().contains(title.toLowerCase())) {
                System.out.println(book);
                cout++;
            }

        }
        if (cout == 0) {
            System.out.println("khong co quyen sach nao co title " + title);
        }
    }

    public void findbyCategory(String category) {
        int cout = 0;
        for (Book book : BookRepository.books) {
            if (book.category.toLowerCase().contains(category.toLowerCase())) {
                System.out.println(book);
                cout++;
            }

        }
        if (cout == 0) {
            System.out.println("khong co quyen sach nao co thể loại " + category);
        }
    }

    public void checkYear() {
        int count = 0;
        LocalDate localDate = LocalDate.now();
        int yearNow = localDate.getYear();
        for (Book book : BookRepository.books) {
            if (book.year == yearNow) {
                System.out.println(book);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("không có quyển nào xuất bản trong năm nay");
        }

    }
}
