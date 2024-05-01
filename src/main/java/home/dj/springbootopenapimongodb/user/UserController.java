package home.dj.springbootopenapimongodb.user;

import home.dj.api.UsersApi;
import home.dj.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UsersApi {

    private final UserService userService;

    @Override
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @Override
    public ResponseEntity<User> find(String id) {
        return ResponseEntity.ok(userService.find(id));
    }

    @Override
    public ResponseEntity<User> create(User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri()).body(savedUser);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<User> update(String id, User user) {
        return ResponseEntity.ok(userService.save(user));
    }
}
