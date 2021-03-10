package maksim.moiseenko.services;

import maksim.moiseenko.models.Discipline;
import maksim.moiseenko.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DisciplineService {
    @Autowired
    private DisciplineRepository disciplineRepository;
    public List<Discipline> findAllDisciplines(){
        return disciplineRepository.findAll();
    }

    public Optional<Discipline> getDiscipline(Long id){
        if(!disciplineRepository.existsById(id)) return Optional.empty();
        return disciplineRepository.findById(id);

    }

    public void deleteDisciplineById(Long id){
        if(disciplineRepository.existsById(id))
            disciplineRepository.deleteById(id);
    }

    public Discipline createDiscipline(Discipline discipline){
        return disciplineRepository.save(discipline);
    }
    public void editDiscipline(Long id,String name){
        Discipline discipline=new Discipline();
        discipline.setId(id);
        discipline.setName(name);
        disciplineRepository.save(discipline);
    }
    public boolean existsById(Long id){
        return disciplineRepository.existsById(id);
    }
}
