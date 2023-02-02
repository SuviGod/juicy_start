package we.juicy.juicyrecipes.repository;

import org.springframework.data.repository.CrudRepository;
import we.juicy.juicyrecipes.domain.Contents;

public interface ContentsRepository extends CrudRepository<Contents, Integer> {
}
