package com.BooksAndJournals.BooksAndJournals.repository;

import com.BooksAndJournals.BooksAndJournals.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {



}
