package task1;

import task1.models.Word;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml")
                        .build();

        Metadata metadata =
                new MetadataSources(serviceRegistry)
                        .addAnnotatedClass(Word.class) /*!!!!!!! register class*/
                        .getMetadataBuilder()
                        .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        //work space

        session.beginTransaction();

        session.save(new Word("i"));
        session.save(new Word("dont"));
        session.save(new Word("know"));
        session.save(new Word("how"));
        session.save(new Word("many"));
        session.save(new Word("times"));
        session.save(new Word("i've"));
        session.save(new Word("redone"));
        session.save(new Word("this"));
        session.save(new Word("task"));
        session.save(new Word("every"));
        session.save(new Word("time"));
        session.save(new Word("there"));
        session.save(new Word("is"));
        session.save(new Word("new"));
        session.save(new Word("mistakes"));
        session.save(new Word("killmeplease"));
        session.getTransaction().commit();


        List<Word> list = session.createQuery("select w from Word w", Word.class).list();
        System.out.println(list);





        /*end don't forget*/
        session.close();
        sessionFactory.close();
    }
}
