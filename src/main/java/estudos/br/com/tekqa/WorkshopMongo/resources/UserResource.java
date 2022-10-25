package estudos.br.com.tekqa.WorkshopMongo.resources;

import estudos.br.com.tekqa.WorkshopMongo.domain.User;
import estudos.br.com.tekqa.WorkshopMongo.dto.UserDTO;
import estudos.br.com.tekqa.WorkshopMongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
  @Autowired
  private UserService service;

  // @GetMapping // Outra forma de notação.
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<UserDTO>> findaAll() {
    List<User> list = service.findAll();
    List<UserDTO> listDto = list.stream().map(x-> new UserDTO(x)).collect(Collectors.toList());
    return ResponseEntity.ok(listDto);
  }
}
