package maksim.moiseenko.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class SimpleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Account account;
    @OneToMany(mappedBy = "user",orphanRemoval = true,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Lesson> Lessons=new ArrayList<>();
    public SimpleUser(String firstname,String lastname){
        this.firstname=firstname;
        this.lastname=lastname;
    }
}
