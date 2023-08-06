package com.rui.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.rui.library.Models.Author;
import com.rui.library.Models.Book;
import com.rui.library.Models.Campus;
import com.rui.library.Repositories.AuthorRepository;
import com.rui.library.Repositories.BookRepository;
import com.rui.library.Repositories.CampusRepository;

import jakarta.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    // Dependance Injection of Repositories
    @Resource
    private CampusRepository campusRepository;

    @Resource
    private AuthorRepository authorRepository;

    @Resource
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {

        Campus campus1 = new Campus("Columbus");
        campusRepository.save(campus1);
        Campus campus2 = new Campus("Cleveland");
        campusRepository.save(campus2);

        Author sierra = new Author("Kathy", "Sierra");
        Author bates = new Author("Burt", "Bates");
        Author beck = new Author("Kent", "Beck");
        Author fowler = new Author("Martin", "Fowler");
        Author martin = new Author("Micah", "Martin");
        authorRepository.save(sierra);
        authorRepository.save(bates);
        authorRepository.save(beck);
        authorRepository.save(fowler);
        authorRepository.save(martin);

        Book headFirstJava = new Book("Head First Java", "A great book to learn Java with", campus1, sierra, bates);
        Book tddByExample = new Book("TDD By Example", "The first book on TDD and still one of the best", campus1, beck);
        Book refactoring = new Book("Refactoring", "The first book to catalog the many refactoring available to address code smells", campus1, fowler);
        Book agileCSharp = new Book("Agile Principles, Patterns and Practices in C#", "A classic book refactored for C#", campus2, martin);
        bookRepository.save(headFirstJava);
        bookRepository.save(tddByExample);
        bookRepository.save(refactoring);
        bookRepository.save(agileCSharp);
    }

}
