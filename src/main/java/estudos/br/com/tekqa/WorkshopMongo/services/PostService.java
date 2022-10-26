package estudos.br.com.tekqa.WorkshopMongo.services;

import estudos.br.com.tekqa.WorkshopMongo.domain.Post;
import estudos.br.com.tekqa.WorkshopMongo.domain.User;
import estudos.br.com.tekqa.WorkshopMongo.repository.PostRepository;
import estudos.br.com.tekqa.WorkshopMongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

  @Autowired private PostRepository repo;

  public Post findById(String id) {
    Optional<Post> obj = repo.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
  }

}
