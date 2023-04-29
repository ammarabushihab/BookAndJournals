package com.BooksAndJournals.BooksAndJournals.controller;

import com.BooksAndJournals.BooksAndJournals.model.*;
import com.BooksAndJournals.BooksAndJournals.service.ResourceServices;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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
    @Operation(summary = "FIND ALL BOOKS")
    public List<Resource> findAllBooks(){
        return resourceServices.getAllBooks();
    }

    @GetMapping("/journals")
    @Operation(summary = "FIND ALL JOURNALS")
    public List<Resource> findAllJournals(){
        return resourceServices.getAllJournals();
    }

    @GetMapping()
    @Operation(summary = "FIND RESOURCE BY ID")
    public Resource findById(@RequestParam Long id){
        return  resourceServices.getById(id).orElseThrow(() -> new RuntimeException("The ID Not Exist"));
    }
    @GetMapping("/available")
    @Operation(summary = "FIND AVAILABLE RESOURCE")
    public List<Resource> findAllAvailable(){
        return  resourceServices.getAvailableResource();
    }

    @GetMapping("/not-available")
    @Operation(summary = "FIND NOT AVAILABLE RESOURCE")
    public List<Resource> findAllNotAvailable(){
        return  resourceServices.getNotAvailableResource();
    }
    @PostMapping()
    @Operation(summary = "ADD NEW RESOURCE")
   public ResponseEntity<Resource> addResource(@Valid @RequestBody  ResourceRequest resource ){


        Resource resource1 = new Resource();
        resource1.setName(resource.getName());
        resource1.setAuthor(resource.getAuthor());
        resource1.setDescription(resource.getDescription());
        resource1.setAvailability(resource.isAvailability());
        resource1.setResourceType(Type.fromValue(resource.getResourceType()));
    return new ResponseEntity<Resource>(resourceServices.addResource(resource1), HttpStatus.OK);



    }

    @DeleteMapping()
    @Operation(summary = "DELETE RESOURCE")
    public String deleteResource(@Valid @RequestParam Long id){
       resourceServices.deleteResource(id);
       return "Delete Successfully";}

    @PutMapping("/available")
    @Operation(summary = "UPDATE RESOURCE")
    public  String updateResource(@Valid @RequestBody UpdateResourceAvailabilityRequest request) {
        resourceServices.updateResource(request.getId(), request.isAvailability());
        return "Update Successfully";
    }

    @Operation(summary = "BORROWING BOOK OR JOURNAL")
    @PutMapping("/borrow")
    public String borrowResource(@RequestBody BorrowResourceRequest borrowResourceRequest){
        resourceServices.borrowResource(borrowResourceRequest);
        return "Borrowed Successfully";
    }
    @Operation(summary = "RETURNING BOOK OR JOURNAL")
    @PutMapping("/return")
    public String returnResource(@RequestBody ReturnResourceRequest returnResourceRequest){
        resourceServices.returnResource(returnResourceRequest);
        return "Returned Successfully";
    }

}
