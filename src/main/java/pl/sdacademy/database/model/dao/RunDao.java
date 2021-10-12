package pl.sdacademy.database.model.dao;

import pl.sdacademy.database.model.entity.Run;

import java.util.List;

public interface RunDao {

    Run findById(Integer id);
    List<Run> findAll();
    void save(Run run);
    void deleteById(Integer id);
}
