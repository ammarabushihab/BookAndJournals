package com.BooksAndJournals.BooksAndJournals.repository;

import com.BooksAndJournals.BooksAndJournals.model.Resource;
import com.BooksAndJournals.BooksAndJournals.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Long> {


    List<Resource> findByResourceType(Type type);
    List<Resource> findByAvailability(boolean availability);
}
