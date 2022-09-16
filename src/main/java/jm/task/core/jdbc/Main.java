package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

//        UserDao userDao = new UserDaoJDBCImpl();

        userService.dropUsersTable();
        userService.createUsersTable();


        userService.saveUser("test1", "test2", (byte)20);
//        userDao.saveUser("Ivan", "Petrov", (byte)30);
//        userDao.saveUser("John", "Peters", (byte)40);
//        userDao.saveUser("Hans", "Peter", (byte)50);

        List<User> allUsers = userService.getAllUsers();
        allUsers.stream()
                .forEach(System.out::println);

        userService.dropUsersTable();
    }
}
