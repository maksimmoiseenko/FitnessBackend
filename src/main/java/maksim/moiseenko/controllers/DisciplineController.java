package maksim.moiseenko.controllers;

import maksim.moiseenko.models.Discipline;
import maksim.moiseenko.services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;
    @GetMapping("/disciplines")
    public List<Discipline> getDisciplines(){
        return disciplineService.findAllDisciplines();
    }
    @PostMapping("/discipline/create")
    public Discipline createDiscipline(@RequestBody Discipline discipline){
        System.out.println(discipline);
        return disciplineService.createDiscipline(discipline);
    }
    @PostMapping("/discipline/delete")
    public void deleteDiscipline(@RequestBody Long id){
        if(disciplineService.existsById(id))
            disciplineService.deleteDisciplineById(id);
    }
    @GetMapping("/discipline/{id}")
    public Optional<Discipline> getDisciplineById(@PathVariable Long id){
            return disciplineService.getDiscipline(id);
    }
    @PostMapping("/discipline/edit")
    public Discipline editDiscipline(@RequestBody Discipline discipline){
        System.out.println(discipline);
        return disciplineService.createDiscipline(discipline);
    }
}
