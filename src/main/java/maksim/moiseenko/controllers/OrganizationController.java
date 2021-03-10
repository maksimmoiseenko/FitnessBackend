package maksim.moiseenko.controllers;

import maksim.moiseenko.models.Account;
import maksim.moiseenko.services.AccountService;
import maksim.moiseenko.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;
    @GetMapping("/organizations")
    public List<Account> getOrganizations(){
        return organizationService.findOrganizations();
    }
    @GetMapping("/3organization")
    public List<Account> get3Organizations(){
        return organizationService.find3Organization();
    }
}
