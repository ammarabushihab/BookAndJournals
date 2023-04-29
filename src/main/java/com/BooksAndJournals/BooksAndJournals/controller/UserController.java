package com.BooksAndJournals.BooksAndJournals.controller;

import com.BooksAndJournals.BooksAndJournals.model.User;
import com.BooksAndJournals.BooksAndJournals.model.UserRequest;
import com.BooksAndJournals.BooksAndJournals.model.UserType;
import com.BooksAndJournals.BooksAndJournals.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {


    @Autowired
    private UserService userService;
    @Operation(summary = "ADD NEW USER")
    @PostMapping()
    public User AddNewUser(UserRequest userRequest){
        User user = new User();
        user.setUserName(userRequest.getUserName());
        user.setUserEmail(userRequest.getUserEmail());
        user.setUserType(UserType.fromValue(userRequest.getUserType()));
        return  userService.SaveUser(user);
    }


}
