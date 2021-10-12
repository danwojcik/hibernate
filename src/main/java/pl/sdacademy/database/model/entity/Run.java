package pl.sdacademy.database.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Run {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer membersLimit;

    @OneToMany(mappedBy = "run")
    private Set<RunMember> members = new HashSet<>();

    public Set<RunMember> getMembers() {
        return members;
    }

    public void setMembers(Set<RunMember> members) {
        this.members = members;
    }

    public Integer getMembersLimit() {
        return membersLimit;
    }

    public void setMembersLimit(Integer membersLimit) {
        this.membersLimit = membersLimit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Run(){
    }

    public Run(Integer id) {
        this.id = id;
    }
}
