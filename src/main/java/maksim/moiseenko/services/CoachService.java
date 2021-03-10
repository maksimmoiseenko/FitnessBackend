package maksim.moiseenko.services;

import maksim.moiseenko.models.Account;
import maksim.moiseenko.repositories.AccountRepository;
import maksim.moiseenko.repositories.CoachDisciplineRepository;
import maksim.moiseenko.repositories.CoachRepository;
import maksim.moiseenko.repositories.OrganizationCoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoachService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OrganizationCoachRepository organizationCoachRepository;


    public List<Account> find3Coaches(){
        return accountRepository.findAll().stream().filter(account ->  account.getCoach()!=null).limit(3).collect(Collectors.toList());
    }
    public List<Account> findCoaches(){
        return accountRepository.findAll().stream().filter(account ->  account.getCoach()!=null).collect(Collectors.toList());
    }
    public Account editCoach(Account account){
        return accountRepository.save(account);
    }
    public Optional<Account> getCoach(Long id){
        return accountRepository.findById(id);
    }
    public void deleteOrganization(Long id, Long organizationId) {
        organizationCoachRepository.delete(organizationCoachRepository.findByCoach_IdAndOrganization_Id(id,organizationId));
    }
}
