package com.rui.library.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.rui.library.Models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    
}
