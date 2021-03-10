package maksim.moiseenko.services;

import maksim.moiseenko.models.Account;
import maksim.moiseenko.models.Lesson;
import maksim.moiseenko.repositories.AccountRepository;
import maksim.moiseenko.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private AccountRepository accountRepository;


    public void create2(Long userId, Account coach, String date, int hours, int minutes){
        Optional<Account> user=accountRepository.findById(userId);
        if(user.isPresent()) {
            try {
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                date1.setHours(hours);
                date1.setMinutes(minutes);


                    try {
                        lessonRepository.save(new Lesson(user.get(), coach, date1));
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }

            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void create(Account user, Long coachId, String date, int hours, int minutes){
        Optional<Account> coach=accountRepository.findById(coachId);
        if(coach.isPresent() ) {
            try {
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                date1.setHours(hours);
                date1.setMinutes(minutes);
                    try {
                        lessonRepository.save(new Lesson(user, coach.get(), date1));
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }

            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public List<Lesson> findAllByCoachIdAndUserId(Long coachId,Long userId){
        return lessonRepository.findAllByCoach_IdAndUser_Id(coachId,userId);
    }
    public List<Lesson> findAllByCoachId(Long id){
        return lessonRepository.findAllByCoach_Id(id);
    }
}
