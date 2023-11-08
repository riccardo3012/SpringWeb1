package controller;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import java.util.List;

@RestController
@RequestMapping("/utente")
public class UserController {

    @Autowired
    private UserService userService;

    List<User> getAllAuthors() {
        return userService.getAllAuthors();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    User save(@RequestBody User user) {
        return userService.save(user);
        
    }

    @GetMapping("/{id}")
    User findAuthorById(@PathVariable int id) {
        return userService.findAuthorById(id);

    }

    @PutMapping("/{id}")
    User findByIdAndUpdate(@PathVariable int id, @RequestBody User user) {
        return userService.findByIdAndUpdate(id, user);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void findByIdAndDelete(@PathVariable int id) {
        userService.findByIdAndDelete(id);

    }

}
