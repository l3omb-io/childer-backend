package dev.childer.childerbackend.service;

import dev.childer.childerbackend.models.BookModel;
import dev.childer.childerbackend.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookModel> findAllBook(){
        return this.bookRepository.findAll();
    }

    public Optional<BookModel> findBookByID(Long id){
        return this.bookRepository.findById(id);
    }

    public BookModel saveBook(BookModel book){
        return this.bookRepository.save(book);
    }

    public Optional<BookModel> updateBook(Long id,BookModel newBook){
        return bookRepository.findById(id).map(book -> {
            book.setChildren(newBook.getChildren());
            book.setAffiliation(newBook.getAffiliation());
            book.setSchoolName(newBook.getSchoolName());
            book.setSchoolYear(newBook.getSchoolYear());
            book.setSchoolLocation(newBook.getSchoolLocation());

            return bookRepository.save(book);
        });

    }

    public void deleteByID(Long id){
        this.bookRepository.deleteById(id);
    }
}
