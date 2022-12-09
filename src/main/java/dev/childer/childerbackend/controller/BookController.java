package dev.childer.childerbackend.controller;

import dev.childer.childerbackend.models.BookModel;
import dev.childer.childerbackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("")
    public @ResponseBody ResponseEntity<List<BookModel>> getAllBook(){
        return new ResponseEntity<>(this.bookService.findAllBook(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Optional<BookModel>> getOneBook(@PathVariable Long id){
        return new ResponseEntity<>(this.bookService.findBookByID(id),HttpStatus.OK);
    }

    @PostMapping("")
    public @ResponseBody ResponseEntity<BookModel> postBook(@RequestBody BookModel book){
        return new ResponseEntity<>(this.bookService.saveBook(book),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<Optional<BookModel>> putBook(@PathVariable Long id,@RequestBody BookModel book){
        return new ResponseEntity<>(this.bookService.updateBook(id,book),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteBook(@PathVariable Long id){
        this.bookService.deleteByID(id);
        return new ResponseEntity<>(String.format("has delete."),HttpStatus.OK);
    }

}
