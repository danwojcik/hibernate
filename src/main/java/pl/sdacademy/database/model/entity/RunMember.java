package pl.sdacademy.database.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RunMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer startNumber;

    @ManyToOne
    @JoinColumn(name = "run_id")
    private Run run;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "nfcTag_runMember",
            joinColumns = {@JoinColumn(name = "member_id")},
            inverseJoinColumns = {@JoinColumn(name = "nfcTag_id")})

    private Set<NfcTag> tags = new HashSet<>();

    public Set<NfcTag> getTags() {
        return tags;
    }

    public void setTags(Set<NfcTag> tags) {
        this.tags = tags;
    }

    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
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

    public Integer getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(Integer startNumber) {
        this.startNumber = startNumber;
    }

    public RunMember(){
    }
}
