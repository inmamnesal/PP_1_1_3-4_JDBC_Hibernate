package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Util.getConnection();
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.dropUsersTable();
        userDao.createUsersTable();

//        userDao.createUsersTable();
//        userDao.dropUsersTable();
//        userDao.createUsersTable();
        userDao.saveUser("test1", "test2", (byte)20);
        userDao.saveUser("Ivan", "Petrov", (byte)30);
        userDao.saveUser("John", "Peters", (byte)40);
        userDao.saveUser("Hans", "Peter", (byte)50);

        List<User> allUsers = userDao.getAllUsers();
        allUsers.stream()
                .forEach(System.out::println);

        userDao.dropUsersTable();
    }
}
