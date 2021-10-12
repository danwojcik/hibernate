package pl.sdacademy.database.model.dao;

import pl.sdacademy.database.model.entity.RunMember;

import java.util.List;

public interface RunMemberDao {

    RunMember findById(Integer id);
    List<RunMember> findAll();
    void save(RunMember runMember);
    void deleteById(Integer id);
    void searchRunner (String searchName);
}
