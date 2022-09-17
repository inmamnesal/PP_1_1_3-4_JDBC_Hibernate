package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(User.class)
            .buildSessionFactory();

//    Session session = null;

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS User " +
                    "(id BIGINT PRIMARY KEY AUTO_INCREMENT," +
                    " name VARCHAR(300)," +
                    " lastName VARCHAR(300), " +
                    "age INT)").executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            String hql = "DROP TABLE IF EXISTS User";
            Query query = session.createSQLQuery(hql);
            query.executeUpdate();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            User item = new User(name, lastName, age);
            session.save(item);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.remove(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> resultList = new ArrayList<>();
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            resultList = session.createQuery("SELECT i FROM User i", User.class).getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public void cleanUsersTable() {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            String hql = "DELETE FROM User";
            Query query = session.createQuery(hql);
            query.executeUpdate();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
