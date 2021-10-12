package pl.sdacademy.database.daoimplement;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdacademy.database.model.dao.RunMemberDao;
import pl.sdacademy.database.model.daoimplement.RunMemberImplement;
import pl.sdacademy.database.model.entity.RunMember;
import pl.sdacademy.database.model.utils.HibernateUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RunMemberImplementTest {

    private RunMemberDao runMemberDao = new RunMemberImplement();

    @BeforeEach
    public void clearTable(){

        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session.createQuery("delete Run")
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void saveAndUpdateTest() {

        RunMember runMember = new RunMember();
        runMember.setName("bieg testowy");
        runMember.setStartNumber(999);

        runMemberDao.save(runMember);

        RunMember saved = runMemberDao.findById(runMember.getId());

        assertNotNull(saved);
        assertEquals(runMember.getId(), saved.getId());
        assertEquals(runMember.getName(), saved.getName());
        assertEquals(runMember.getStartNumber(), saved.getStartNumber());
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {

        RunMember member1 = new RunMember();
        member1.setName("bieg 1");
        member1.setStartNumber(100);

        RunMember member2 = new RunMember();
        member2.setName("bieg 2");
        member2.setStartNumber(200);

        runMemberDao.save(member1);
        runMemberDao.save(member2);

        List<RunMember> runMemberList = runMemberDao.findAll();

        assertNotNull(runMemberList);
        assertEquals(2, runMemberList.size());

        RunMember foundMember1 = null;
        if (runMemberList.get(0).getId() == member1.getId()) {
            foundMember1 = runMemberList.get(0);
        } else {
            foundMember1 = runMemberList.get(0);
        }
        assertNotNull(foundMember1);
        assertEquals(member1.getId(), foundMember1.getId());
        assertEquals(member1.getName(), foundMember1.getName());
        assertEquals(member1.getStartNumber(), foundMember1.getStartNumber());
    }

    @Test
    void deleteById() {

        RunMember member = new RunMember();
        member.setName("test name");
        member.setStartNumber(20);

        runMemberDao.save(member);
        runMemberDao.deleteById(member.getId());

        RunMember deleted = runMemberDao.findById(member.getId());
        assertNull(deleted);
    }

    @Test
    void searchRunner() {

        RunMember runner1 = new RunMember();
        runner1.setName("Rafal");

        RunMember runner2 = new RunMember();
        runner2.setName("Pawel");

        runMemberDao.save(runner1);
        runMemberDao.save(runner2);
    }
}