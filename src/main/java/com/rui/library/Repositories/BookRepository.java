package com.rui.library.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.rui.library.Models.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
    
}
