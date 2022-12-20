import models.Car;
import models.Engine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {


        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml")
                        .build();

        Metadata metadata =
                new MetadataSources(serviceRegistry)
                        .addAnnotatedClass(Car.class) /*!!!!!!! register class*/
                        .addAnnotatedClass(Engine.class)
                        .getMetadataBuilder()
                        .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        //work space

        session.beginTransaction();
session.save(new Car("bmv","sx",1999,new Engine("43074hgj3904")));
session.save(new Car("bmv","sx",1949,new Engine("88337234dfs4")));
session.save(new Car("bmv","sx",1959,new Engine("adfdw3323204")));

        session.getTransaction().commit();




        /*end don't forget*/
        session.close();
        sessionFactory.close();
    }
}
