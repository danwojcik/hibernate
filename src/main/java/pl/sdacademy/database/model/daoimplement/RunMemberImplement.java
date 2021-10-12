package pl.sdacademy.database.model.daoimplement;

import org.hibernate.Session;
import pl.sdacademy.database.model.dao.RunMemberDao;
import pl.sdacademy.database.model.entity.RunMember;
import pl.sdacademy.database.model.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.List;

public class RunMemberImplement implements RunMemberDao {

    public void save(RunMember runMember) {

        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session.saveOrUpdate(runMember);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void searchRunner(String name) {

        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        RunMember searchName = null;

        try {
            searchName = session
                    .createQuery("from RunMember where name like :name", RunMember.class)
                    .setParameter("name", "%" + searchName + "%")
                    .getSingleResult();

        }catch (NoResultException ex){
        }

    }

    @Override
    public RunMember findById(Integer id) {

        RunMember runMember = null;
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        try {
            runMember = session
                    .createQuery("from RunMember where id=:id", RunMember.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }catch (NoResultException ex){
            System.out.println("nie ma takiego ID w bazie");
        }

        session.getTransaction().commit();
        session.close();

        return runMember;
    }

    @Override
    public List<RunMember> findAll() {

        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        List<RunMember> runMemberList = session.createQuery("from RunMember" , RunMember.class).list();

        session.getTransaction().commit();
        session.close();
        return runMemberList;
    }

    @Override
    public void deleteById(Integer id) {

        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session.createQuery("delete RunMember where id=:id")
                .setParameter("id",id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}
