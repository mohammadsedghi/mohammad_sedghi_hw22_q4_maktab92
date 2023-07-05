package base.repository.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
//    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY
//            = Persistence.createEntityManagerFactory("vote");
//    public static EntityManagerFactory getEntityManagerFactory() {
//        return ENTITY_MANAGER_FACTORY;
//    }

    private static final StandardServiceRegistry ssr=new StandardServiceRegistryBuilder()
            .configure("hibernate.cfg.xml").build();
    private static final Metadata metadata=new MetadataSources(ssr).getMetadataBuilder().build();
    private static final SessionFactory sessionFactory= metadata.getSessionFactoryBuilder().build();
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
