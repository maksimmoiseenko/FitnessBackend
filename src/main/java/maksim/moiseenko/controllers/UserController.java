package maksim.moiseenko.controllers;

import maksim.moiseenko.models.Account;
import maksim.moiseenko.services.SimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private SimpleUserService userService;
    @GetMapping("/users")
    public List<Account> getUsers(){
        return userService.getUsers();
    }
}
