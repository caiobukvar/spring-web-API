package learning.spring_web_API.controller;

import learning.spring_web_API.model.User;
import learning.spring_web_API.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") //seta o prefixo para todos os Mappings abaixo
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping()
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/{username}")
    //path variable para definir qual será o item usado na URI
    public User getUser(@PathVariable("username") String username){
        return userRepository.findByUsername(username);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id)  {
        userRepository.deleteById(id);
    }

    @PostMapping()
    public void postUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
