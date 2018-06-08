package in.roth.graphqldemo.repositories;

import org.springframework.data.repository.CrudRepository;
import in.roth.graphqldemo.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
