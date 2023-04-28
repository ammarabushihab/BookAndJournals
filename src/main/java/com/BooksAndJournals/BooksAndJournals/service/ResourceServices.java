package com.BooksAndJournals.BooksAndJournals.service;

import com.BooksAndJournals.BooksAndJournals.error.RecordNotFoundException;
import com.BooksAndJournals.BooksAndJournals.model.Book;
import com.BooksAndJournals.BooksAndJournals.model.Resource;
import com.BooksAndJournals.BooksAndJournals.model.Type;
import com.BooksAndJournals.BooksAndJournals.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceServices {


    @Autowired
    private ResourceRepository resourceRepository;

    public  List<Resource> getAllBooks(){
        return resourceRepository.findByResourceType(Type.BOOK);
    }

    public  List<Resource> getAllJournals(){
        return resourceRepository.findByResourceType(Type.JOURNAL);
    }

    public Optional<Resource> getById(Long id){
        return  resourceRepository.findById(id);
    }


    public  List<Resource> getAvailableResource(){
        return resourceRepository.findByAvailability(true);
    }


    public  Resource addResource(Resource resource){
      return   resourceRepository.save(resource);
    }
    public void deleteResource(Long id){
        resourceRepository.deleteById(id);
    }


    public  void updateResource(Long id,boolean availability){
        Optional<Resource> byId = resourceRepository.findById(id);
        if (byId.isPresent()){
            Resource resource = byId.get();

            resource.setAvailability(availability);
        }else {
            throw new RecordNotFoundException("ID Does Not Exist");
        }


    }




//
//    public List<Book> findAllBooks(){
//       return bookRepository.findAll();
//    }
//
//    public Book getBookById(long id){
//
//        return     bookRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("This Book is Not Found With ID :-"+ id));}
//
//    public  void addBook(Book book){
//        bookRepository.save(book);}
//
//    public  void updateBook(Book book){
//        bookRepository.save(book);}
//
//    public void deleteBook(long id){
//        bookRepository.deleteById(id);}
//

}
