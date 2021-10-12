package pl.sdacademy.database.model.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
    private static HibernateUtils instance;

    private SessionFactory sessionFactory;

    private HibernateUtils() {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.xml")
                .build();
        Metadata metadata = new MetadataSources(standardServiceRegistry)
                .getMetadataBuilder()
                .build();

        sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static HibernateUtils getInstance(){
        if(instance==null){
            instance=new HibernateUtils();
        }
        return instance;
    }
}
