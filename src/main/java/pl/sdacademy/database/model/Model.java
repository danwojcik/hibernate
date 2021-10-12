package pl.sdacademy.database.model;

import pl.sdacademy.database.model.dao.RunDao;
import pl.sdacademy.database.model.dao.RunMemberDao;
import pl.sdacademy.database.model.daoimplement.RunDaoImlement;
import pl.sdacademy.database.model.daoimplement.RunMemberImplement;
import pl.sdacademy.database.model.entity.Run;
import pl.sdacademy.database.model.entity.RunMember;

import java.util.List;

public class Model {

    private RunDao runDao;
    private RunMemberDao runMemberDao;

    public Model() {

        runDao = new RunDaoImlement();
        runMemberDao = new RunMemberImplement();
    }

    public List<RunMember> getAllRunner() {

        List<RunMember> list = runMemberDao.findAll();
        return list;
    }

    public List<Run> getAllRuns() {

        List<Run> list = runDao.findAll();
        return list;
    }

    public void save(RunMember runMember) {
        runMemberDao.save(runMember);
    }

    public void save(Run run) {
        runDao.save(run);
    }

    public void deleteRunnersById(Integer runMember) {
        runMemberDao.deleteById(runMember);
    }

    public RunMember findById(Integer runMember) {
        return runMemberDao.findById(runMember);
    }

    public void deleteRunsById(Integer run) {
        runDao.deleteById(run);
    }
}
