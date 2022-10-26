package estudos.br.com.tekqa.WorkshopMongo.resources;

import estudos.br.com.tekqa.WorkshopMongo.domain.User;
import estudos.br.com.tekqa.WorkshopMongo.dto.UserDTO;
import estudos.br.com.tekqa.WorkshopMongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
  @Autowired private UserService service;

  // @GetMapping // Outra forma de notação.
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<UserDTO>> findaAll() {
    List<User> list = service.findAll();
    List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    return ResponseEntity.ok(listDto);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<UserDTO> findById(@PathVariable String id) {
    User obj = service.findById(id);
    return ResponseEntity.ok(new UserDTO(obj));
  }

  // @PostMapping // Outra forma de notação.
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
    User obj = service.fromDTO(objDto);
    obj = service.insert(obj);
    URI uri =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(obj.getId())
            .toUri(); // Pega o endereço do novo usuario criado.
    return ResponseEntity.created((uri)).build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> delete(@PathVariable String id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Void> update(@RequestBody UserDTO objDto,@PathVariable String id) {
   User obj = service.fromDTO(objDto);
   obj.setId(id);
   obj = service.update(obj);
   return ResponseEntity.noContent().build();
  }
}
