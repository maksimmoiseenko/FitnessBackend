package maksim.moiseenko.controllers;

import maksim.moiseenko.Forms.FormLogin;

import maksim.moiseenko.models.Account;
import maksim.moiseenko.models.Organization;
import maksim.moiseenko.models.Token;
import maksim.moiseenko.services.AccountService;
import maksim.moiseenko.services.CoachService;
import maksim.moiseenko.services.OrganizationService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/sign_in")
    public Token sign_in(@RequestBody FormLogin loginForm){
        if(accountService.findByLoginAndPassword(loginForm)!=null){
            Token token=new Token();
            token.setValue(RandomStringUtils.random(10,true,true));
            return token;
        }
        return null;
    }
    @PostMapping("/sign_up")
    public Account sign_up(@RequestBody Account account){
        System.out.println(account.toString());
        return accountService.singUp(account);
    }






}
