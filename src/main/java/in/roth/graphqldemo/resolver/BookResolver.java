package in.roth.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import in.roth.graphqldemo.model.Author;
import in.roth.graphqldemo.model.Book;
import in.roth.graphqldemo.repositories.AuthorRepository;

public class BookResolver implements GraphQLResolver<Book> {

    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    
    public Author getAuthor(Book book) {
        return authorRepository.findOne(book.getAuthor().getId());
    }
    
}
