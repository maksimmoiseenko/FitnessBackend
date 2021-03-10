package maksim.moiseenko.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State status;
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    @JoinColumn

    private Organization organization;
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    @JoinColumn(name="coach_id")

    private Coach coach;
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    @JoinColumn(name="user_id")

    private SimpleUser user;
    @OneToMany(mappedBy = "account")
    private List<Token> tokens=new ArrayList<>();


    public Account(String login, String password, Role role, State state, Organization o, Coach o1, SimpleUser o2) {
        this.login=login;
        this.password=password;
        this.role=role;
        this.status=state;
        this.organization=o;
        this.coach=o1;
        this.user=o2;
    }


    @Override
    public String toString() {
        String result=this.login+"\n"+this.password;

        if(this.organization!=null)
                result+="\n"+this.organization.getName()+"\n"+this.organization.getLocation();
        if(this.coach!=null)
                result+="\n"+this.coach.getFirstname()+"\n"+this.coach.getLastname();
        if(this.user!=null)
                result+="\n"+this.user.getFirstname()+"\n"+this.user.getLastname();
        return result;
    }
}
