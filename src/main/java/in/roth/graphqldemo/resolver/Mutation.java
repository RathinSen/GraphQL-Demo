package in.roth.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import in.roth.graphqldemo.model.Author;
import in.roth.graphqldemo.model.Book;
import in.roth.graphqldemo.repositories.AuthorRepository;
import in.roth.graphqldemo.repositories.BookRepository;

public class Mutation implements GraphQLMutationResolver {
    
    private AuthorRepository authorRepository;
    
    private BookRepository bookRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        super();
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    
    
    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }
    
    public boolean deleteBook(Long id) {
        bookRepository.delete(id);
        return true;
    }
    
    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findOne(id);
        if(null != book){
            book.setPageCount(pageCount);
            bookRepository.save(book);
        }


        return book;
    }
    
    

}
