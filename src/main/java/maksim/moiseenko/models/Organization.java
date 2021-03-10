package maksim.moiseenko.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
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

public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    @OneToOne(mappedBy = "organization")
    @JsonIgnore
    private Account account;
    @OneToMany(mappedBy = "organization",orphanRemoval = true,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Organization_Coach> organization_coach=new ArrayList<>();



    public Organization(String name, String location) {
        this.name=name;
        this.location=location;
    }
    public Organization(Long id,String name, String location) {
        this.id=id;
        this.name=name;
        this.location=location;
    }

}
