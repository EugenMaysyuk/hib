package com.may;

import com.may.entities.Info;
import com.may.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            User user = new User();
            user.setUsername( "Test" );
            user.setPassword( "12345" );
            user.setAge(23);

            Info info = new Info();
            info.setBankId( 1 );
            info.setText1( "text1" );
            info.setText2( "text2" );
            info.setText3( "text3" );

            session.save( user );
            session.save( info );

            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
        finally {
            StandardServiceRegistryBuilder.destroy( registry );
        }

    }
}
