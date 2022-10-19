package estudos.br.com.tekqa.WorkshopMongo.resources;

import estudos.br.com.tekqa.WorkshopMongo.domain.User;
import estudos.br.com.tekqa.WorkshopMongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
  @Autowired private UserService service;

  // @GetMapping // Outra forma de notação.
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<User>> findaAll() {
    List<User> list = service.findAll();
    return ResponseEntity.ok(list);
  }
}
