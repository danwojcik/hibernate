package pl.sdacademy.database.daoimplement;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdacademy.database.model.dao.NfcDao;
import pl.sdacademy.database.model.dao.RunMemberDao;
import pl.sdacademy.database.model.daoimplement.NfcDaoImplements;
import pl.sdacademy.database.model.daoimplement.RunMemberImplement;
import pl.sdacademy.database.model.entity.NfcTag;
import pl.sdacademy.database.model.entity.RunMember;
import pl.sdacademy.database.model.utils.HibernateUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NfcDaoImplementsTest {

    private NfcDao nfcDao = new NfcDaoImplements();
    private RunMemberDao runMemberDao = new RunMemberImplement();

    @BeforeEach
    public void clearTable(){

        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session.createQuery("delete NfcTag")
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }


    @Test
    void save() {

        NfcTag nfcTag = new NfcTag();
        nfcTag.setId(1);
        nfcTag.setSerialNumber(999);

        nfcDao.save(nfcTag);

        NfcTag saved = nfcDao.findById(nfcTag.getId());

        assertNotNull(saved);
        assertEquals(nfcTag.getId(), saved.getId());
        assertEquals(nfcTag.getSerialNumber(), saved.getSerialNumber());
    }

    @Test
    public void manyToManyTest() {

        NfcTag nfcTag = new NfcTag();
        nfcTag.setSerialNumber(234);
        nfcDao.save(nfcTag);

        RunMember member = new RunMember();
        member.getTags().add(nfcTag);
        runMemberDao.save(member);

        NfcTag saved = nfcDao.findById(nfcTag.getId());

        assertNotNull(saved);
        assertNotNull(saved.getMembers());
        assertEquals(1, saved.getMembers().size());
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {

        NfcTag nfcTag1 = new NfcTag();
        nfcTag1.setSerialNumber(2345);

        NfcTag nfcTag2 = new NfcTag();
        nfcTag2.setSerialNumber(7891);

        nfcDao.save(nfcTag1);
        nfcDao.save(nfcTag2);

        List<NfcTag> nfcTagList = nfcDao.findAll();

        assertNotNull(nfcTagList);
        assertEquals(2, nfcTagList.size());

        NfcTag foundNfcTag1 = null;
        if (nfcTagList.get(0).getId() == nfcTag1.getId()) {
            foundNfcTag1 = nfcTagList.get(0);
        } else {
            foundNfcTag1 = nfcTagList.get(0);
        }
        assertNotNull(foundNfcTag1);
        assertEquals(nfcTag1.getId(), foundNfcTag1.getId());
        assertEquals(nfcTag1.getSerialNumber(), foundNfcTag1.getSerialNumber());
    }

    @Test
    void deleteById() {

        NfcTag nfcTag = new NfcTag();
        nfcTag.setSerialNumber(20);

        nfcDao.save(nfcTag);
        nfcDao.deleteById(nfcTag.getId());

        NfcTag deleted = nfcDao.findById(nfcTag.getId());
        assertNull(deleted);
    }
}