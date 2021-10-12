package pl.sdacademy.database.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class NfcTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer serialNumber;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "tags")
    private Set<RunMember> members = new HashSet<>();

    public Set<RunMember> getMembers() {
        return members;
    }

    public void setMembers(Set<RunMember> members) {
        this.members = members;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }
}