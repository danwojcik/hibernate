package pl.sdacademy.database.model.daoimplement;

import org.hibernate.Session;
import pl.sdacademy.database.model.dao.RunDao;
import pl.sdacademy.database.model.entity.Run;
import pl.sdacademy.database.model.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.List;

public class RunDaoImlement implements RunDao {

    public void save(Run run) {

        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session.saveOrUpdate(run);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Run findById(Integer id) {

        Run run = null;
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        try {
            run = session
                    .createQuery("from Run where id=:id", Run.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }catch (NoResultException ex){
        }

        session.getTransaction().commit();
        session.close();

        return run;
    }

    @Override
    public List<Run> findAll() {

            Session session = HibernateUtils
                    .getInstance()
                    .getSessionFactory()
                    .getCurrentSession();
            session.beginTransaction();

            List<Run> runList = session.createQuery("from Run" , Run.class).list();

        session.getTransaction().commit();
        session.close();
            return runList;
    }

    @Override
    public void deleteById(Integer id) {

        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session.createQuery("delete Run where id=:id")
                .setParameter("id",id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}
