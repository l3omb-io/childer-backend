//package dev.childer.childerbackend.service;
//
//import dev.childer.childerbackend.models.BookModel;
//import dev.childer.childerbackend.repositories.BookRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BookService {
//
//    private final BookRepository bookRepository;
//
//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//
//    public List<BookModel> findAllBook(){
//        return this.bookRepository.findAll();
//    }
//
//    public BookModel findBookByID(Long id){
//        return this.bookRepository.getReferenceById(id);
//    }
//
//    public BookModel saveBook(BookModel book){
//        return this.bookRepository.save(book);
//    }
//
//    public BookModel updateBook(Long id,BookModel book){
//        BookModel b = findBookByID(id);
//
//        b.setChildren(book.getChildren());
//        b.setAffiliation(book.getAffiliation());
//        b.setSchoolName(book.getSchoolName());
//        b.setSchoolYear(book.getSchoolYear());
//        b.setSchoolLocation(book.getSchoolLocation());
//
//        bookRepository.save(b);
//        return b;
//    }
//
//    public void deleteByID(Long id){
//        this.bookRepository.deleteById(id);
//    }
//}
