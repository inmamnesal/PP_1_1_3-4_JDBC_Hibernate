package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.saveUser("test1", "test2", (byte)20);
        userService.saveUser("test3", "test4", (byte)40);
        userService.saveUser("test5", "test6", (byte)60);


        List<User> allUsers = userService.getAllUsers();
        allUsers.stream()
                .forEach(System.out::println);

    }
}
