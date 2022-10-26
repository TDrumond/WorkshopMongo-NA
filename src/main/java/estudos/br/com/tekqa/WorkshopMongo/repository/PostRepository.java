package estudos.br.com.tekqa.WorkshopMongo.repository;

import estudos.br.com.tekqa.WorkshopMongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {}
