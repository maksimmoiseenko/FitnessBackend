package maksim.moiseenko.controllers;

import maksim.moiseenko.models.Account;
import maksim.moiseenko.models.Discipline;
import maksim.moiseenko.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CoachController {
    @Autowired
    private CoachService coachService;

    @GetMapping("/3coach")
    public List<Account> get3Coach(){
        return coachService.find3Coaches();
    }

    @GetMapping("/coaches")
    public List<Account> getCoaches(){
        return coachService.findCoaches();
    }

    @GetMapping("/coach/{id}")
    public Optional<Account> getCoachById(@PathVariable Long id){
        return coachService.getCoach(id);
    }

    @PostMapping("/coach/edit")
    public Account editAccount(@RequestBody Account account){
        System.out.println(account);
        return coachService.editCoach(account);
    }
}
