package com.BooksAndJournals.BooksAndJournals.service;

import com.BooksAndJournals.BooksAndJournals.error.RecordNotFoundException;
import com.BooksAndJournals.BooksAndJournals.model.*;
import com.BooksAndJournals.BooksAndJournals.repository.ResourceRepository;
import com.BooksAndJournals.BooksAndJournals.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ResourceServices {


    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private UserRepository userRepository;

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

    public  List<Resource> getNotAvailableResource(){
        return resourceRepository.findByAvailability(false);
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
            resourceRepository.save(resource);
        }else {
            throw new RecordNotFoundException("ID Does Not Exist");}
    }

    public void borrowResource(BorrowResourceRequest borrowResourceRequest){
        Optional<User> userOptional = userRepository.findById(borrowResourceRequest.getUserId());
        Optional<Resource> resourceOptional = resourceRepository.findById(borrowResourceRequest.getResourceId());
        if(!userOptional.isPresent() || !resourceOptional.isPresent()){
            throw new RuntimeException("user id or resource id does't exist");
        }
        Resource resource = resourceOptional.get();
        User user = userOptional.get();
        if(!resource.isAvailability()){
            throw new RuntimeException("resource is not available");
        }
        resource.setBorrowingBy(user);
        resource.setAvailability(false);
        resourceRepository.save(resource);
    }

    public void returnResource(ReturnResourceRequest returnResourceRequest){
        Optional<User> userOptional = userRepository.findById(returnResourceRequest.getUserId());
        Optional<Resource> resourceOptional = resourceRepository.findById(returnResourceRequest.getResourceId());
        if(!userOptional.isPresent() || !resourceOptional.isPresent()){
            throw new RuntimeException("user id or resource id does't exist");
        }
        Resource resource = resourceOptional.get();
        User user = userOptional.get();
        if(Objects.isNull(resource.getBorrowingBy()) || resource.getBorrowingBy().getUserId() != user.getUserId()){
            throw new RuntimeException("invalid user");
        }
        resource.setAvailability(true);
        resource.setBorrowingBy(user);
        resourceRepository.save(resource);
    }

}
