import models.Car;
import models.Engine;
import models.Wheels;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml")
                        .build();

        Metadata metadata =
                new MetadataSources(serviceRegistry)
                        .addAnnotatedClass(Car.class) /*!!!!!!! register class*/
                        .addAnnotatedClass(Wheels.class)
                        .getMetadataBuilder()
                        .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        //work space

        session.beginTransaction();

        session.save(new Car("bmv", "sx", 1959,
                Arrays.asList(new Wheels(20),new Wheels(21))));
session.save(new Car("bmv", "sx", 1959,
                Arrays.asList(new Wheels(12),new Wheels(12))));


        session.getTransaction().commit();




        /*end don't forget*/
        session.close();
        sessionFactory.close();
    }
}
