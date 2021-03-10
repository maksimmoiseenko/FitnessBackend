package maksim.moiseenko.services;

import maksim.moiseenko.models.Account;
import maksim.moiseenko.repositories.AccountRepository;
import maksim.moiseenko.repositories.OrganizationCoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrganizationService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OrganizationCoachRepository organizationCoachRepository;

    public List<Account> find3Organization(){
        return accountRepository.findAll().stream().filter(account ->  account.getOrganization()!=null).limit(3).collect(Collectors.toList());
    }
    public List<Account> findOrganizations(){
        return accountRepository.findAll().stream().filter(account ->  account.getOrganization()!=null).collect(Collectors.toList());
    }
    public void deleteCoach(Long coachId, Long organizationId) {
        organizationCoachRepository.delete(organizationCoachRepository.findByCoach_IdAndOrganization_Id(coachId,organizationId));
    }
}
