package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;

public interface UserDao {
    void createUsersTable();

    void dropUsersTable();

    //create
    void saveUser(String name, String lastName, byte age);

    //delete
    void removeUserById(long id);

    //read
    List<User> getAllUsers();

    //delete all
    void cleanUsersTable();
}
