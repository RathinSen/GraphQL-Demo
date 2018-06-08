package in.roth.graphqldemo.repositories;

import org.springframework.data.repository.CrudRepository;
import in.roth.graphqldemo.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
