package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public void addUser(User user);

    public void saveUser(User user);

    public User getUser(long id);

    public void deleteUser(long id);

}
