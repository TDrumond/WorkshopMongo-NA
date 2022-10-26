package estudos.br.com.tekqa.WorkshopMongo.repository;

import estudos.br.com.tekqa.WorkshopMongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {}
