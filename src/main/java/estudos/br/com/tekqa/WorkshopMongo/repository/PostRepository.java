package estudos.br.com.tekqa.WorkshopMongo.repository;

import estudos.br.com.tekqa.WorkshopMongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
  List<Post> findByTitleContainingIgnoreCase(String text);

  // Query:
  //        ?0 -> indica a primeira ocorrência encontrada
  //        i -> indica que é case-insensitive (ignora maiúsculas e minúsculas)
  @Query("{ 'title': {$regex: ?0, $options: 'i'} }")
  List<Post> serachByTitle(String text);
}



















