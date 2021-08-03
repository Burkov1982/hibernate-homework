package ua.goit.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateDatabaseConnector {
    private static SessionFactory sessionFactory;

    public static synchronized void init(){
        System.out.println("Init hibernate connection");
        MetadataSources source = new MetadataSources(new StandardServiceRegistryBuilder().configure().build());
        Metadata data = source.getMetadataBuilder().build();
        sessionFactory = data.getSessionFactoryBuilder().build();
        System.out.println("Hibernate connection finished successfully");
    }

    public static synchronized void destroy() {
        if (sessionFactory != null){
            sessionFactory.close();
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory==null){
            init();
        }
        return sessionFactory;
    }
}
