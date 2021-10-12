package pl.sdacademy.database.daoimplement;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import pl.sdacademy.database.model.dao.RunDao;
import pl.sdacademy.database.model.daoimplement.RunDaoImlement;
import pl.sdacademy.database.model.entity.Run;

import pl.sdacademy.database.model.utils.HibernateUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RunDaoImlementTest {

    private RunDao runDao = new RunDaoImlement();

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

    @org.junit.jupiter.api.Test
    public void saveAndUpdateTest() {

        Run run = new Run();
        run.setName("bieg testowy");
        run.setMembersLimit(999);

        runDao.save(run);

        Run saved = runDao.findById(run.getId());

        assertNotNull(saved);
        assertEquals(run.getId(), saved.getId());
        assertEquals(run.getName(), saved.getName());
        assertEquals(run.getMembersLimit(), saved.getMembersLimit());
    }

    @org.junit.jupiter.api.Test
    void findById() {
    }

    @org.junit.jupiter.api.Test
    void findAll() {

        Run member1 = new Run();
        member1.setName("bieg 1");
        member1.setMembersLimit(100);

        Run member2 = new Run();
        member2.setName("bieg 2");
        member2.setMembersLimit(200);

        runDao.save(member1);
        runDao.save(member2);

        List<Run> list = runDao.findAll();

        assertNotNull(list);
        assertEquals(2, list.size());

        Run foundMember1 = null;
        if (list.get(0).getId() == member1.getId()) {
            foundMember1 = list.get(0);
        } else {
            foundMember1 = list.get(0);
        }
        assertNotNull(foundMember1);
        assertEquals(member1.getId(), foundMember1.getId());
        assertEquals(member1.getName(), foundMember1.getName());
        assertEquals(member1.getMembersLimit(), foundMember1.getMembersLimit());
    }

    @org.junit.jupiter.api.Test
    void deleteById() {

            Run member = new Run();
            member.setName("test name");
            member.setMembersLimit(20);

            runDao.save(member);
            runDao.deleteById(member.getId());

            Run deleted = runDao.findById(member.getId());
            assertNull(deleted);
    }
}