package in.roth.graphqldemo.resolver;

import java.util.List;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import in.roth.graphqldemo.model.Author;
import in.roth.graphqldemo.model.Book;
import in.roth.graphqldemo.repositories.AuthorRepository;
import in.roth.graphqldemo.repositories.BookRepository;

public class Query implements GraphQLQueryResolver{

    private AuthorRepository authorRepository;
    
    private BookRepository bookRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        super();
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    
    public List<Book> findAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public List<Author> findAllAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }
    public long countAuthors() {
        return authorRepository.count();
    }
    
    
}
