package com.BooksAndJournals.BooksAndJournals.controller;

import com.BooksAndJournals.BooksAndJournals.model.Book;
import com.BooksAndJournals.BooksAndJournals.model.Resource;
import com.BooksAndJournals.BooksAndJournals.model.UpdateResourceAvailabilityRequest;
import com.BooksAndJournals.BooksAndJournals.service.ResourceServices;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/resource")
public class ResourceController {

//localhost:7777/api/v1/"(Delete,Get,Put,Post)"
    @Autowired
    private ResourceServices resourceServices;

    @GetMapping("/book")
    public List<Resource> findAllBooks(){
        return resourceServices.getAllBooks();
    }

    @GetMapping("/journals")
    public List<Resource> findAllJournals(){
        return resourceServices.getAllJournals();
    }

    @GetMapping()
    public Resource findById(@RequestParam Long id){
        return  resourceServices.getById(id).orElseThrow(() -> new RuntimeException("The ID Not Exist"));
    }
    @GetMapping("/available")
    public List<Resource> findAllAvailabile(){
        return  resourceServices.getAvailableResource();
    }

    @PostMapping()
   public ResponseEntity<Resource> addResource(@Valid @RequestBody Resource resource){
        return new ResponseEntity<Resource>(resourceServices.addResource(resource), HttpStatus.OK);}

    @DeleteMapping()
    public String deleteResource(@RequestParam Long id){
       resourceServices.deleteResource(id);
       return "Delete Successfully";}

    @PutMapping("/available")
    public  String updateResource(@Valid @RequestBody UpdateResourceAvailabilityRequest request) {
        resourceServices.updateResource(request.getId(), request.isAvailability());
        return "Update Successfully";
    }


    //
//    @Operation(summary = "FIND ALL BOOKS")
//    @GetMapping("/book")
//    public List<Book> getAllBooks(){
//        return bookServices.findAllBooks();
//    }
//
//    @Operation(summary = "FIND BOOK BY ID")
//    @GetMapping("/bookById")
//    public Book getBookID(@RequestParam long id) {
//        return bookServices.getBookById(id);}
//
//
//    @Operation(summary = "ADD NEW BOOK")
//    @PostMapping("/book")
//    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book){
//        bookServices.addBook(book);
//        return new ResponseEntity<Book>(book, HttpStatus.OK);}
//
//    @Operation(summary = "HANDEL EXIST BOOK")
//    @PutMapping("/book")
//    public  ResponseEntity<Book> updateBook(@Valid @RequestBody Book book){
//        bookServices.updateBook(book);
//        return new ResponseEntity<Book>(book, HttpStatus.OK);}
//
//    @Operation(summary = "DELETE BOOK")
//    @DeleteMapping("/book")
//    public String deleteBook(@RequestParam Long id){
//        bookServices.deleteBook(id);
//        return "Delete Successfully";}
//
//



}
