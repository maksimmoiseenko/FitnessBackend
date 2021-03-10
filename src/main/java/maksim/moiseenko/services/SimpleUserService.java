package maksim.moiseenko.services;

import maksim.moiseenko.models.Account;
import maksim.moiseenko.models.Role;
import maksim.moiseenko.models.SimpleUser;
import maksim.moiseenko.models.State;
import maksim.moiseenko.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SimpleUserService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getUsers(){
        return accountRepository.findAll()
                .stream()
                .filter(account -> account.getUser()!=null)
                .collect(Collectors.toList());
    }

}
