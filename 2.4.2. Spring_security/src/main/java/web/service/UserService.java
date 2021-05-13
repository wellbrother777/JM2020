package web.service;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    Optional<User> findUserByUserName(String userName);

    public List<User> listUsers();

    public void addUser(User user);

    public void saveUser(User user);

    public User getUser(long id);

    public void deleteUser(long id);

}
