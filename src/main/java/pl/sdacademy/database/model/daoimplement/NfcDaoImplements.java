package pl.sdacademy.database.model.daoimplement;

import org.hibernate.Session;
import pl.sdacademy.database.model.dao.NfcDao;
import pl.sdacademy.database.model.entity.NfcTag;
import pl.sdacademy.database.model.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.List;

public class NfcDaoImplements implements NfcDao {

    public void save(NfcTag nfcTag) {

        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session.saveOrUpdate(nfcTag);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public NfcTag findById(Integer id) {

        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        NfcTag nfcTag = null;
        try {
            nfcTag = session
                    .createQuery("from NfcTag where id=:id", NfcTag.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }catch (NoResultException ex){}

        session.getTransaction().commit();
        session.close();

        return nfcTag;
    }

    @Override
    public List<NfcTag> findAll() {

        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        List<NfcTag> nfcTagList = session.createQuery("from NfcTag" , NfcTag.class).list();

        session.getTransaction().commit();
        session.close();
        return nfcTagList;
    }

    @Override
    public void deleteById(Integer id) {

        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session.createQuery("delete NfcTag where id=:id")
                .setParameter("id",id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}
