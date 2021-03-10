package maksim.moiseenko.services;


import maksim.moiseenko.Forms.FormLogin;
import maksim.moiseenko.models.Account;
import maksim.moiseenko.models.Role;
import maksim.moiseenko.models.State;
import maksim.moiseenko.repositories.AccountRepository;
import maksim.moiseenko.repositories.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TokenRepository tokenRepository;

    public Account findByLoginAndPassword(FormLogin loginForm){
        return accountRepository.findAccountByLoginAndPassword(loginForm.getLogin(),loginForm.getPassword());
    }
    public Account singUp(Account account){
        account.setStatus(State.ACTIVE);
        if(account.getOrganization()!=null)
            account.setRole(Role.ORGANIZATION);
        if(account.getCoach()!=null)
            account.setRole(Role.COACH);
        if(account.getUser()!=null)
            account.setRole(Role.USER);
        return accountRepository.save(account);
    }
    public Optional<Account> getAccount(Long id){
        if(!accountRepository.existsById(id)) return null;
        return accountRepository.findById(id);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
