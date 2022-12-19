package task2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import task1.models.Word;
import task2.models.Car;
import task2.models.Owner;
import task2.models.Type;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml")
                        .build();

        Metadata metadata =
                new MetadataSources(serviceRegistry)
                        .addAnnotatedClass(Owner.class)
                        .addAnnotatedClass(Car.class)/*!!!!!!! register class*/
                        .getMetadataBuilder()
                        .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        //work space

        session.beginTransaction();


        session.save(new Owner("koko", new Car("gr",300,Type.DIESEL,200,2020)));
        session.save(new Owner("moko",new Car("xs",3000, Type.BENZ, 230, 1939)));
        session.save(new Owner("lola",new Car("ddl",4000, Type.DIESEL, 230, 1999)));

        session.getTransaction().commit();




        /*end don't forget*/
        session.close();
        sessionFactory.close();
    }
}
