package com.BooksAndJournals.BooksAndJournals.service;

import com.BooksAndJournals.BooksAndJournals.model.User;
import com.BooksAndJournals.BooksAndJournals.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

public User SaveUser(User user){
    return  userRepository.save(user);
}




}
